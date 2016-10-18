package com.helibrothers.dico.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.helibrothers.dico.domain.embeddable.UserInfo;
import com.helibrothers.dico.domain.enums.DeliveryStatusCd;

import javax.persistence.*;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Entity
@Table(name = "tb_delivery")
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery")
    @JsonIgnore
    private Order order;

    @Embedded
    private UserInfo userInfo;

    @Enumerated(EnumType.STRING)
    private DeliveryStatusCd status;

    public Delivery() {

    }

    public Delivery(UserInfo userInfo) {
        this.userInfo = userInfo;
        this.status = DeliveryStatusCd.DELIVERY;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public DeliveryStatusCd getStatus() {
        return this.status;
    }

    public void setStatus(DeliveryStatusCd status) {
        this.status = status;
    }


}
