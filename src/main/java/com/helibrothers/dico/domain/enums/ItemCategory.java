package com.helibrothers.dico.domain.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
public enum ItemCategory {
    FRESH("신선식품"),
    MEAT("축산/달걀"),
    INSTANT("가공식품"),
    SIDE("양념/반찬"),
    ETC("기타");

    private String nameKr;

    ItemCategory(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }
}
