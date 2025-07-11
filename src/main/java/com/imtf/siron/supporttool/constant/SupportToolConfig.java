package com.imtf.siron.supporttool.constant;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "support")
public class SupportToolConfig {

    private boolean createListOfFiles;
    private boolean getProdInfoAml;
    private boolean getProdInfoKyc;
    private boolean getProdInfoZeidon;
    private boolean getProdInfoEmbargo;
    private boolean getProdInfoRas;
    private boolean getProdInfoRcc;
    private boolean getSystemInfo;

    public boolean isCreateListOfFiles() {
        return createListOfFiles;
    }

    public void setCreateListOfFiles(boolean createListOfFiles) {
        this.createListOfFiles = createListOfFiles;
    }

    public boolean isGetProdInfoAml() {
        return getProdInfoAml;
    }

    public void setGetProdInfoAml(boolean getProdInfoAml) {
        this.getProdInfoAml = getProdInfoAml;
    }

    public boolean isGetProdInfoKyc() {
        return getProdInfoKyc;
    }

    public void setGetProdInfoKyc(boolean getProdInfoKyc) {
        this.getProdInfoKyc = getProdInfoKyc;
    }

    public boolean isGetProdInfoZeidon() {
        return getProdInfoZeidon;
    }

    public void setGetProdInfoZeidon(boolean getProdInfoZeidon) {
        this.getProdInfoZeidon = getProdInfoZeidon;
    }

    public boolean isGetProdInfoEmbargo() {
        return getProdInfoEmbargo;
    }

    public void setGetProdInfoEmbargo(boolean getProdInfoEmbargo) {
        this.getProdInfoEmbargo = getProdInfoEmbargo;
    }

    public boolean isGetProdInfoRas() {
        return getProdInfoRas;
    }

    public void setGetProdInfoRas(boolean getProdInfoRas) {
        this.getProdInfoRas = getProdInfoRas;
    }

    public boolean isGetProdInfoRcc() {
        return getProdInfoRcc;
    }

    public void setGetProdInfoRcc(boolean getProdInfoRcc) {
        this.getProdInfoRcc = getProdInfoRcc;
    }

    public boolean isGetSystemInfo() {
        return getSystemInfo;
    }

    public void setGetSystemInfo(boolean getSystemInfo) {
        this.getSystemInfo = getSystemInfo;
    }
}
