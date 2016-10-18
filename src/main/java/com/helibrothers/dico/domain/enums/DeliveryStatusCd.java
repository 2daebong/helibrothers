package com.helibrothers.dico.domain.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
public enum DeliveryStatusCd {
    PICKUP("픽업"),
    DELIVERY("배달");

    private String nameKr;

    DeliveryStatusCd(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }
}
