package com.helibrothers.dico.domain.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
public enum ItemCategory {
    VEGETABLE("야채"),
    FRUIT("과일"),
    MEAT("축산/계란"),
    RICE("쌀/잡곡/견과"),
    DRIED_FISH("건어물"),
    ETC("기타");

    private String nameKr;

    ItemCategory(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {
        return nameKr;
    }
}
