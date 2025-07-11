package com.imtf.siron.supporttool.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.imtf.siron.supporttool.exception.SecurityException;
import java.nio.file.Path;
import java.nio.file.Files;

public class FileHelper {

    private static final Logger logger = LoggerFactory.getLogger(FileHelper.class);

    public boolean checkFilePermission(Path applicationPath) {
        try {
            boolean isReadable = Files.isReadable(applicationPath);
            boolean isWritable = Files.isWritable(applicationPath);
            boolean isExecutable = Files.isExecutable(applicationPath);

            if (!isReadable) {
                logger.warn("Permission check failed: Path '{}' is not readable.", applicationPath);
            }
            if (!isWritable) {
                logger.warn("Permission check failed: Path '{}' is not writable.", applicationPath);
            }
            if (!isExecutable) {
                logger.warn("Permission check failed: Path '{}' is not executable.", applicationPath);
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
}
