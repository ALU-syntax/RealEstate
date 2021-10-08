/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.interfaces;

import com.RealEstate.Kelompok2_3SC3.models.Property;
import java.util.List;

/**
 *
 * @author macbook
 */
public interface PropertyInterface {
    List<Property> getAll();
    void store(Property property);
    Property getById(long id);
    void delete(long id);
    List<Property> findByUserId(long user_id);
    
}
