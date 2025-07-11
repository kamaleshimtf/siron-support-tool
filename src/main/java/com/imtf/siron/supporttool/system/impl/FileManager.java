package com.imtf.siron.supporttool.system.impl;

import java.nio.file.Path;

public interface FileManager {

    public boolean checkFilePermission(Path applicationPath);
    public String prepareSupportToolDirectory(Path applicationPath);
}
