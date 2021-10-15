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
    public void saveProductToDB(String name, int price, Category categoryId,
            Customer customerId, int area, int bedrooms, String city, int bathroom,
            String desc, MultipartFile file, MultipartFile file2, 
            MultipartFile file3, MultipartFile file4) {
        Property p = new Property();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
                String fileName2 = StringUtils.cleanPath(file2.getOriginalFilename());
                String fileName3 = StringUtils.cleanPath(file3.getOriginalFilename());
                String fileName4 = StringUtils.cleanPath(file4.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
                        p.setImage2(Base64.getEncoder().encodeToString(file.getBytes()));
                        p.setImage3(Base64.getEncoder().encodeToString(file.getBytes()));
                        p.setImage4(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
                p.setName(name);
                p.setPrice(price);
                p.setCategoryId(categoryId);
                p.setCustomerId(customerId);
                p.setArea(area);
                p.setBedrooms(bedrooms);
                p.setCity(city);
                p.setBathroom(bathroom);
                
        
        propertyRepository.save(p);
    }

    @Override
    public List<Property> findByUserid(long user_id) {
        return propertyRepository.findByUserid(user_id);
    }

    @Override
    public Property getById(long id) {
        Optional< Property> optional = propertyRepository.findById(id);

        if (!optional.isPresent()) {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        
        Property property = optional.get();
        return property;
    }

    @Override
    public void updateProductToDB(String name, int price, Category categoryId,
            Customer customerId, int area, int bedrooms, String city, int bathroom,
            String desc, MultipartFile file, MultipartFile file2, 
            MultipartFile file3, MultipartFile file4) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(long id) {
        this.propertyRepository.deleteById(id);
    }
    
    
}
