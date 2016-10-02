package com.helibrothers.dico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helibrothers.dico.domain.embeddable.UserInfo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @Column(name = "user_id")
    private String id;

    private String name;

    @Embedded
    private UserInfo userInfo;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<Order>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date registYmdt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateYmdt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Date getRegistYmdt() {
        return registYmdt;
    }

    public void setRegistYmdt(Date registYmdt) {
        this.registYmdt = registYmdt;
    }

    public Date getUpdateYmdt() {
        return updateYmdt;
    }

    public void setUpdateYmdt(Date updateYmdt) {
        this.updateYmdt = updateYmdt;
    }

    @PrePersist
    void onCreate() {
        this.setRegistYmdt(new Timestamp((new Date()).getTime()));
    }

    @PreUpdate
    void onPersist() {
        this.setUpdateYmdt(new Timestamp((new Date()).getTime()));
    }
}
