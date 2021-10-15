/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.interfaces;

import com.RealEstate.Kelompok2_3SC3.models.Category;
import com.RealEstate.Kelompok2_3SC3.models.Customer;
import com.RealEstate.Kelompok2_3SC3.models.Property;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author macbook
 */
public interface PropertyInterface {
    List<Property> getAll();
    
    void  saveProductToDB(String name, int price, Category categoryId,
            Customer customerId, int area, int bedrooms, String city, int bathroom,
            String desc, MultipartFile file, MultipartFile file2, 
            MultipartFile file3, MultipartFile file4);
    
    List<Property> findByUserid(long customer_id);
    
    Property getById(long id);
    
    void updateProductToDB(String name, int price, Category categoryId,
            Customer customerId, int area, int bedrooms, String city, int bathroom,
            String desc, MultipartFile file, MultipartFile file2, 
            MultipartFile file3, MultipartFile file4);
    
    void delete(long id);
    
}
