/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author macbook
 */
@Entity
@Table(name="property")
public class Property {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="price")
    private long price;
    
    @Column(name="category_id")
    private long category_id;
    
    @Column(name="customer_id")
    private long customer_id;
    
    @Column(name="area")
    private long area;
    
    @Column(name="bedroom")
    private long bedroom;
    
    @Column(name="name")
    private String city;
    
    @Column(name="bathroom")
    private long bathroom;
    
    @Column(name="description")
    private String desc;
    
    @Column(name="image", columnDefinition = "longblob")
    private String image;
    
    @Column(name="image2", columnDefinition = "longblob")
    private String image2;
    
    @Column(name="image3", columnDefinition = "longblob")
    private String image3;
    
    @Column(name="image4", columnDefinition = "longblob")
    private String image4;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getBedroom() {
        return bedroom;
    }

    public void setBedroom(long bedroom) {
        this.bedroom = bedroom;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getBathroom() {
        return bathroom;
    }

    public void setBathroom(long bathroom) {
        this.bathroom = bathroom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }
    
    
    
}
