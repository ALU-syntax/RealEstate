/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author macbook
 */
@Entity
@Table(name="property")
public class Property implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="price")
    private long price;
    
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category categoryId;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customerId;
    
    @Column(name="area")
    private long area;
    
    @Column(name="bedrooms")
    private long bedrooms;
    
    @Column(name="city")
    private String city;
    
    @Column(name="garden_area")
    private long gardenArea;
    
    @Column(name="bathroom")
    private long bathroom;
    
    @Column(name="description")
    private String description;
    
    @Column(name = "image", columnDefinition = "longblob")
    private String image;
    
    @Column(name = "image2", columnDefinition = "longblob")
    private String image2;
    
    @Column(name = "image3", columnDefinition = "longblob")
    private String image3;
    
    @Column(name = "image4", columnDefinition = "longblob")
    private String image4;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public long getArea() {
        return area;
    }

    public void setArea(long area) {
        this.area = area;
    }

    public long getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(long bedrooms) {
        this.bedrooms = bedrooms;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getGardenArea() {
        return gardenArea;
    }

    public void setGardenArea(long gardenArea) {
        this.gardenArea = gardenArea;
    }

    public long getBathroom() {
        return bathroom;
    }

    public void setBathroom(long bathroom) {
        this.bathroom = bathroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
