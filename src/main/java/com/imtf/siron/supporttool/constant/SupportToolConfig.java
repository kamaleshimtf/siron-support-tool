package com.imtf.siron.supporttool.constant;

import io.smallrye.config.ConfigMapping;

import java.util.List;

@ConfigMapping(prefix = "support")
public class SupportToolConfig {

    private String createListOfFiles;
    private String getProdInfoAml;
    private String getProdInfoKyc;
    private String getProdInfoZeidon;
    private String getProdInfoEmbargo;
    private String getProdInfoRas;
    private String getProdInfoRcc;
    private String getSystemInfo;
    private List<String> contentFilter;
    private List<String> folderFilter;
    private List<String> fileNameFilter;

    public String isCreateListOfFiles() {
        return createListOfFiles;
    }

    public void setCreateListOfFiles(String createListOfFiles) {
        this.createListOfFiles = createListOfFiles;
    }

    public String isGetProdInfoAml() {
        return getProdInfoAml;
    }

    public void setGetProdInfoAml(String getProdInfoAml) {
        this.getProdInfoAml = getProdInfoAml;
    }

    public String isGetProdInfoKyc() {
        return getProdInfoKyc;
    }

    public void setGetProdInfoKyc(String getProdInfoKyc) {
        this.getProdInfoKyc = getProdInfoKyc;
    }

    public String isGetProdInfoZeidon() {
        return getProdInfoZeidon;
    }

    public void setGetProdInfoZeidon(String getProdInfoZeidon) {
        this.getProdInfoZeidon = getProdInfoZeidon;
    }

    public String isGetProdInfoEmbargo() {
        return getProdInfoEmbargo;
    }

    public void setGetProdInfoEmbargo(String getProdInfoEmbargo) {
        this.getProdInfoEmbargo = getProdInfoEmbargo;
    }

    public String isGetProdInfoRas() {
        return getProdInfoRas;
    }

    public void setGetProdInfoRas(String getProdInfoRas) {
        this.getProdInfoRas = getProdInfoRas;
    }

    public String isGetProdInfoRcc() {
        return getProdInfoRcc;
    }

    public void setGetProdInfoRcc(String getProdInfoRcc) {
        this.getProdInfoRcc = getProdInfoRcc;
    }

    public String isGetSystemInfo() {
        return getSystemInfo;
    }

    public void setGetSystemInfo(String getSystemInfo) {
        this.getSystemInfo = getSystemInfo;
    }

    public List<String> getContentFilter() {
        return contentFilter;
    }

    public void setContentFilter(List<String> contentFilter) {
        this.contentFilter = contentFilter;
    }

    public List<String> getFolderFilter() {
        return folderFilter;
    }

    public void setFolderFilter(List<String> folderFilter) {
        this.folderFilter = folderFilter;
    }

    public List<String> getFileNameFilter() {
        return fileNameFilter;
    }

    public void setFileNameFilter(List<String> fileNameFilter) {
        this.fileNameFilter = fileNameFilter;
    }
}
