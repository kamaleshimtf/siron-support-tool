package com.imtf.siron.supporttool.system;

import com.imtf.siron.supporttool.exception.InvalidPathException;
import jakarta.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

@ApplicationScoped
public class OperatingSystemHelper {

    private final Logger logger = LoggerFactory.getLogger(OperatingSystemHelper.class);

    public Path getApplicationPath() {
        try {
            return Paths.get("").toAbsolutePath();
        } catch (SecurityException exception) {
            logger.error("SecurityException: Unable to access the current directory due to security restrictions.{}", exception.getMessage());
            throw exception;
        } catch (InvalidPathException exception) {
            logger.error("InvalidPathException: Unable to access the current directory due to invalid path {}", exception.getMessage());
            throw exception;
        } catch (Exception exception) {
            logger.error("Unexpected exception occurred while determining application path.{}", exception.getMessage());
            throw exception;
        }
    }

    public Map<String,String> getEnvironmentVariables() {
        return System.getenv();
    }
}
