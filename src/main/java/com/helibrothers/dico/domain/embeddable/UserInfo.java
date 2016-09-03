package com.helibrothers.dico.domain.embeddable;

import javax.persistence.Embeddable;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Embeddable
public class UserInfo {

    private String address;
    private String phoneNumber;

    public UserInfo() {
    }

    public UserInfo(String address, String phoneNumber) {
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
