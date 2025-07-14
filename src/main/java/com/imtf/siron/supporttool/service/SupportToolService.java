package com.imtf.siron.supporttool.service;

import com.imtf.siron.supporttool.constant.SensitiveFileContents;
import com.imtf.siron.supporttool.constant.SironProductConfig;
import com.imtf.siron.supporttool.constant.SupportToolConfig;
import com.imtf.siron.supporttool.constant.SupportToolConstant;
import com.imtf.siron.supporttool.model.SironProductType;
import com.imtf.siron.supporttool.system.FileHelper;
import com.imtf.siron.supporttool.system.OperatingSystemHelper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@ApplicationScoped
public class SupportToolService {

    private final Logger logger = LoggerFactory.getLogger(SupportToolService.class);
    private Path supportToolPathDirectory;
    private String supportToolFileName;

    @Inject
    SupportToolConfig supportToolConfig;

    @Inject
    SironProductConfig sironProductConfig;

    @Inject
    OperatingSystemHelper operatingSystemHelper;

    @Inject
    FileHelper fileHelper;

    @Inject
    SupportToolConfigService supportToolConfigService;

    @Inject
    SensitiveFileContents sensitiveFileContents;

    public String createTempDirectory() {

        logger.info("Creating temporary directory");
        Path basePath = operatingSystemHelper.getApplicationPath();

        if (fileHelper.checkFilePermission(basePath)) {
            this.supportToolPathDirectory = basePath.resolve(SupportToolConstant.TEMP_DIR_NAME);
            this.supportToolFileName = fileHelper.prepareSupportToolDirectory(supportToolPathDirectory);

            Map<SironProductType, String> supportToolConfigRootMap = getInstalledProducts();

            System.out.println(supportToolConfigRootMap);
            return this.supportToolFileName;
        }
        return "File not created";
    }

    public Map<SironProductType, String> getInstalledProducts() {

        List<Pattern> contentFilter = supportToolConfigService.getSensitivePatterns();
        if (!contentFilter.isEmpty()) {
            sensitiveFileContents.addCustomSensitivePatterns(contentFilter);
        }

        return operatingSystemHelper.getEnvironmentVariables().entrySet().stream()
                .map(entry -> {
                    SironProductType sironProductType = sironProductConfig.getProductTypeByRoot(entry.getKey());
                    String sironProductPath = entry.getValue();
                    if (sironProductType != null && sironProductPath != null && new File(sironProductPath).exists()) {
                        logger.info("Found product Installation {} at path: {}", sironProductType, sironProductPath);
                        return Map.entry(sironProductType, sironProductPath);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    public Path getSupportToolPathZipDirectory() {
        return supportToolPathDirectory;
    }

    public String getSupportToolFileName() {
        return supportToolFileName;
    }
}
