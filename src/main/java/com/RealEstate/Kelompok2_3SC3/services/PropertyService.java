/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.services;

import com.RealEstate.Kelompok2_3SC3.interfaces.PropertyInterface;
import com.RealEstate.Kelompok2_3SC3.models.Category;
import com.RealEstate.Kelompok2_3SC3.models.Customer;
import com.RealEstate.Kelompok2_3SC3.models.Property;
import com.RealEstate.Kelompok2_3SC3.repositories.PropertyRepository;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author macbook
 */
@Service
public class PropertyService implements PropertyInterface{
    
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    

    @Override
    public List<Property> findByCustomerId(long customer_id) {
        return propertyRepository.findByCustomerId(customer_id);
    }

    @Override
    public Property getById(long id) {
                Optional < Property > optional = propertyRepository.findById(id);

        if (!optional.isPresent()) {
        throw new RuntimeException(" Todo not found for id :: " + id);
    }

    Property property = optional.get();
        return property;

    }

    @Override
    public void saveProductToDB(MultipartFile file,  String title, long price,
            long categoryId, long customer_id, long area, long bedroom,
            String city, long bathroom, String desc) {
        
       Property property = new Property();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			property.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
//        String fileName2 = StringUtils.cleanPath(file.getOriginalFilename());
//        if(fileName2.contains(".."))
//		{
//			System.out.println("not a a valid file");
//		}
//		try {
//			property.setImage2(Base64.getEncoder().encodeToString(file.getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        String fileName3 = StringUtils.cleanPath(file.getOriginalFilename());
//        if(fileName3.contains(".."))
//		{
//			System.out.println("not a a valid file");
//		}
//		try {
//			property.setImage3(Base64.getEncoder().encodeToString(file.getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        String fileName4 = StringUtils.cleanPath(file.getOriginalFilename());
//        if(fileName4.contains(".."))
//		{
//			System.out.println("not a a valid file");
//		}
//		try {
//			property.setImage4(Base64.getEncoder().encodeToString(file.getBytes()));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

        property.setTitle(title);
        property.setPrice(price);
        property.setCategoryId(categoryId);
        property.setCustomerId(customer_id);
        property.setArea(area);
        property.setBedroom(bedroom);
        property.setCity(city);
        property.setBathroom(bathroom);
        property.setDesc(desc);
        
        propertyRepository.save(property);
    }

    @Override
    public void updateProductToDB(MultipartFile file, MultipartFile file2,
            MultipartFile file3, MultipartFile file4, long id, String title,
            long price, long categoryId, long customerId, long area,
            long bedroom, String city, long bathroom, String desc) {
        
    }

    

    @Override
    public void delete(long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
