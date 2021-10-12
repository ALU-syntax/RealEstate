/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.services;

import com.RealEstate.Kelompok2_3SC3.interfaces.PropertyInterface;
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
public class PropertyService implements PropertyInterface {
    
    @Autowired
    private PropertyRepository propertyRepository;

    @Override
    public List<Property> getAll() { 
        
        return propertyRepository.findAll();
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
    public void delete(long id) {
        this.propertyRepository.deleteById(id);
    }

    @Override
    public List<Property> findByUserId(long user_id) {
        return propertyRepository.findByUserId(user_id);
    }

    @Override
    public void saveProductToDB(MultipartFile file, String name, String desc, long price, long id, long area, long bedrooms, long garage, long gardenArea, long bathroom) {
        		Property p = new Property();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	p.setName(name);
        p.setDescription(desc);
        p.setPrice(price);
        p.setId(id);
        p.setArea(area);
        p.setBedrooms(bedrooms);
        p.setBathroom(bathroom);
        p.setGarage(garage);
        p.setGardenArea(gardenArea);
        
        
        propertyRepository.save(p);

    }

    @Override
    public void updateProductToDB(MultipartFile file, String name, long price, long categoryId, long customerId, long area, long bedrooms, long garage, long gardenArea, long bathroom, String desc) {
        
    }

    
    
    
}
