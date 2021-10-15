/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.repositories;

import com.RealEstate.Kelompok2_3SC3.models.Property;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author macbook
 */
@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByUserid(long user_id);
}
