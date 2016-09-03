package com.helibrothers.dico.domain;

import com.helibrothers.dico.domain.enums.ItemCategory;
import com.helibrothers.dico.domain.enums.StockUnitCd;
import com.helibrothers.dico.exception.NotEnoughStockException;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 25..
 */
@Entity
@Table(name = "tb_item")
public class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private ItemCategory category;

    private int price;

    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private StockUnitCd stockUnitCd;

    private String imageUrl;

    private String itemDesc;

    @Temporal(TemporalType.TIMESTAMP)
    private Date registYmdt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateYmdt;

    private int sortGroup;

    // == business logic
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int restStock = this.stockQuantity - quantity;
        if (restStock < 0) {
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemCategory getCategory() {
        return category;
    }

    public void setCategory(ItemCategory category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public StockUnitCd getStockUnitCd() {
        return stockUnitCd;
    }

    public void setStockUnitCd(StockUnitCd stockUnitCd) {
        this.stockUnitCd = stockUnitCd;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public void setItemDesc(String itemDesc) {
        this.itemDesc = itemDesc;
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

    public int getSortGroup() {
        return sortGroup;
    }

    public void setSortGroup(int sortGroup) {
        this.sortGroup = sortGroup;
    }
}
