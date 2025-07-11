package com.imtf.siron.supporttool.constant;

import com.imtf.siron.supporttool.model.SironProductType;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class SironProductConfig {
    private static final String AML_ROOT = "AML_ROOT";
    private static final String KYC_ROOT = "KYC_ROOT";
    private static final String ZEIDON_ROOT = "FS_ZEIDON_ROOT";
    private static final String EMBARGO_ROOT = "EMB_ROOT";
    private static final String RAS_ROOT = "RAS_ROOT";
    private static final String RCC_ROOT = "RCC_ROOT";
    private static final Map<String, SironProductType> SIRON_ROOT_TO_TYPE_MAP = new HashMap<>();


    public SironProductConfig() {
        initializeSironProductRoots();
    }

    public void initializeSironProductRoots(){
        SIRON_ROOT_TO_TYPE_MAP.put(AML_ROOT, SironProductType.AML);
        SIRON_ROOT_TO_TYPE_MAP.put(KYC_ROOT, SironProductType.KYC);
        SIRON_ROOT_TO_TYPE_MAP.put(ZEIDON_ROOT, SironProductType.ZEIDON);
        SIRON_ROOT_TO_TYPE_MAP.put(EMBARGO_ROOT, SironProductType.EMBARGO);
        SIRON_ROOT_TO_TYPE_MAP.put(RAS_ROOT, SironProductType.RAS);
        SIRON_ROOT_TO_TYPE_MAP.put(RCC_ROOT, SironProductType.RCC);
    }

    public SironProductType getProductTypeByRoot(String rootVar) {
        return SIRON_ROOT_TO_TYPE_MAP.get(rootVar);
    }

}
