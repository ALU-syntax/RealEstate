/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.interfaces;

import com.RealEstate.Kelompok2_3SC3.models.Customer;

/**
 *
 * @author macbook
 */
public interface CustomerInterface {
    void register(Customer customer) throws Exception;
    Customer auth(String email, String password) throws Exception;
}
