package com.imtf.siron.supporttool.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class OperatingSystemHelper {

    private final Logger logger = LoggerFactory.getLogger(OperatingSystemHelper.class);

    public Path getApplicationPath(){
        try{
            return Paths.get("").toAbsolutePath();
        }
        catch(SecurityException exception){
            logger.error("SecurityException: Unable to access the current directory due to security restrictions.{}", exception.getMessage());
            return Paths.get(".");
        }
        catch(Exception exception){
            logger.error("Unexpected exception occurred while determining application path.{}", exception.getMessage());
            return Paths.get(".");
        }
    }
}
