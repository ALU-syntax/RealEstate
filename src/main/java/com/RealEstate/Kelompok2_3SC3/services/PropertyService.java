/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.services;

import com.RealEstate.Kelompok2_3SC3.interfaces.PropertyInterface;
import com.RealEstate.Kelompok2_3SC3.models.Property;
import com.RealEstate.Kelompok2_3SC3.repositories.PropertyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author macbook
 */
public class PropertyService implements PropertyInterface {
 
    @Autowired
    private PropertyRepository propertyRepository;
    
    @Override
    public List<Property> getAll() {
        return propertyRepository.findAll();
    }

    @Override
    public void store(Property property) {
        this.propertyRepository.save(property);
    }
    
    @Override
    public Property getById(long id) {
        Optional < Property > optional = propertyRepository.findById(id);

        if (!optional.isPresent()) {
        throw new RuntimeException(" Property not found for id :: " + id);
    }

    Property todo = optional.get();
        return todo;
    }

    @Override
    public void delete(long id) {
        this.propertyRepository.deleteById(id);
    }
    
    @Override
    public List<Property> findByUserId(long user_id) {
        return propertyRepository.findByUserId(user_id);
    }
}
