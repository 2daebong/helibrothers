package com.helibrothers.dico.domain.enums;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
public enum OrderStatusCd {
    WAIT("배송전"),
    ING("배송중"),
    COMPLETE("배송완료"),
    CANCEL("취소");

    public void setNameKr(String nameKr) {
        this.nameKr = nameKr;
    }

    public String getNameKr() {

        return nameKr;
    }

    private String nameKr;

    OrderStatusCd(String nameKr) {
        this.nameKr = nameKr;
    }
}
