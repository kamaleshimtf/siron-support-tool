package com.imtf.siron.supporttool.system;

import com.imtf.siron.supporttool.constant.SupportToolConstant;
import com.imtf.siron.supporttool.system.impl.FileManager;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imtf.siron.supporttool.exception.SecurityException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

@ApplicationScoped
public class FileHelper implements FileManager {

    private static final Logger logger = LoggerFactory.getLogger(FileHelper.class);

    public boolean checkFilePermission(Path applicationPath) {
        try {
            boolean isReadable = Files.isReadable(applicationPath);
            boolean isWritable = Files.isWritable(applicationPath);
            boolean isExecutable = Files.isExecutable(applicationPath);

            if (!isReadable || !isWritable || !isExecutable) {
                logger.warn("Permission check failed for path '{}' [readable={}, writable={}, executable={}]",
                        applicationPath, isReadable, isWritable, isExecutable);
            }

            return isReadable && isWritable && isExecutable;

        } catch (SecurityException exception) {
            logger.error("SecurityException: Access denied while checking permissions for path '{}'. {}", applicationPath, exception.getMessage());
            throw new SecurityException(exception.getMessage());
        } catch (Exception exception) {
            logger.error("Unexpected exception occurred while checking file permissions for path '{}'. {}", applicationPath, exception.getMessage());
            throw exception;
        }
    }

    public String prepareSupportToolDirectory(Path applicationPath) {

        try {
            if (Files.exists(applicationPath)) {
                logger.info("Directory {} exists. Deleting...", applicationPath);
                try {
                    Files.delete(applicationPath);
                } catch (IOException e) {
                    logger.warn("Directory {} could not be deleted. {}", applicationPath, e.getMessage());
                }
            }

            Files.createDirectories(applicationPath);

            logger.info("Created directory: {}", applicationPath);

        } catch (IOException e) {
            logger.error("Error while preparing support tool directory: {}", e.getMessage());
        }

        return applicationPath.toAbsolutePath().toString();
    }

}
