package com.helibrothers.dico.domain.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
public enum StockUnitCd {
    ONE("개"),
    GROUP("묶음"),
    DAN("단");

    private String nameKr;

    StockUnitCd(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }

    public void setNameKr(String nameKr) {
        this.nameKr = nameKr;
    }
}
