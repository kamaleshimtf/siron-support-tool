package com.imtf.siron.supporttool.service;

import com.imtf.siron.supporttool.constant.SupportToolConstant;
import com.imtf.siron.supporttool.system.FileHelper;
import com.imtf.siron.supporttool.system.OperatingSystemHelper;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;

@ApplicationScoped
public class SupportToolService {

    private final Logger logger = LoggerFactory.getLogger(SupportToolService.class);
    private Path zipDirectoryPath;

    OperatingSystemHelper operatingSystemHelper = new OperatingSystemHelper();
    FileHelper fileHelper = new FileHelper();

    public String createTempDirectory() {

        logger.info("Creating temporary directory");
        Path basePath = operatingSystemHelper.getApplicationPath();

        if(fileHelper.checkFilePermission(basePath)) {
            zipDirectoryPath = basePath.resolve(SupportToolConstant.TEMP_DIR_NAME);
            System.out.println(zipDirectoryPath);
        }

        return "zip file pathjkehcveluih";
    }
}
