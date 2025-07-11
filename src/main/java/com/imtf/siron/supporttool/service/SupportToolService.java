package com.imtf.siron.supporttool.service;

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
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
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

        Map<String, String> environmentVariables = new HashMap<>(operatingSystemHelper.getEnvironmentVariables());
        Set<String> environmentKeyValue = environmentVariables.keySet();

        return environmentVariables.entrySet().stream()
                .filter(entry -> {
                    SironProductType type = sironProductConfig.getProductTypeByRoot(entry.getKey());
                    String path = entry.getValue();
                    return type != null && path != null && new File(path).exists();
                })
                .collect(Collectors.toMap(
                        entry -> sironProductConfig.getProductTypeByRoot(entry.getKey()),
                        Map.Entry::getValue
                ));
    }


    public Path getSupportToolPathZipDirectory() {
        return supportToolPathDirectory;
    }

    public String getSupportToolFileName() {
        return supportToolFileName;
    }
}
