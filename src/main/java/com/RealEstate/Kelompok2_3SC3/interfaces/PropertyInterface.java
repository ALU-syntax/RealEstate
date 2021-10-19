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
    
    void  saveProductToDB(MultipartFile file,MultipartFile file2,
            MultipartFile file3, MultipartFile file4, String title,long price
			,long categoryId, long customerId, long area,
                        long bedroom, String city, long bathroom, String desc
                        );
    
    List<Property> findByCustomerId(long customer_id);
    
    Property getById(long id);
    
    void  updateProductToDB(MultipartFile file,MultipartFile file2,
            MultipartFile file3, MultipartFile file4,long id, String title,
            long price,long categoryId,long customerId, long area,
            long bedroom, String city, long bathroom, String desc );
    
    void delete(long id);
    
}
