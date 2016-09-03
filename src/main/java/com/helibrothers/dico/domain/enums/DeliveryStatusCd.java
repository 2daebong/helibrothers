package com.helibrothers.dico.domain.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
public enum DeliveryStatusCd {
    READY("준비"),
    COMPLETE("배송완료");

    private String nameKr;

    DeliveryStatusCd(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }
}
