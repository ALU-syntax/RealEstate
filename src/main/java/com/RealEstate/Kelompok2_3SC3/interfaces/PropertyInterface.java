/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.interfaces;

import java.util.List;

/**
 *
 * @author macbook
 */
public interface PropertyInterface {
    List<Property> getAll();
    void store(Todo todo);
    Todo getById(long id);
    void delete(long id);
    List<Todo> findByUserId(long user_id);
    
}
