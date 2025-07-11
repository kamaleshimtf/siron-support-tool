package com.imtf.siron.supporttool.system;

import java.nio.file.Path;
import java.nio.file.Files;

public class FileHelper {

    public boolean checkFilePermission(Path applicationPath){
        return Files.isReadable(applicationPath) && Files.isWritable(applicationPath) && Files.isExecutable(applicationPath);
    }
}
