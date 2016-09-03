package com.helibrothers.dico.domain;

import com.helibrothers.dico.domain.embeddable.UserInfo;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "user")
    private List<Order> orders = new ArrayList<Order>();

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

}
