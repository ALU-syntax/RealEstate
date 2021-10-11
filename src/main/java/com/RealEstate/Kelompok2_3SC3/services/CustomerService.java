/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.services;

import com.RealEstate.Kelompok2_3SC3.interfaces.CustomerInterface;
import com.RealEstate.Kelompok2_3SC3.models.Customer;
import com.RealEstate.Kelompok2_3SC3.repositories.CustomerRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author macbook
 */
@Service
public class CustomerService implements CustomerInterface {
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void register(Customer customer) throws Exception {
        String hashed = this.hash(customer.getPassword());
        customer.setPassword(hashed);
        
        this.customerRepository.save(customer);
    }

    @Override
    public Customer auth(String email, String password) throws Exception {
        Customer customer = customerRepository.findByEmail(email);

        if (customer == null) {
            return null;
        }

        if (!this.match(customer.getPassword(), password)) {
            return null;
        }

        return customer;
    }

    private String hash(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");

        byte[] messageDiggest = md.digest(password.getBytes());

        BigInteger no = new BigInteger(1, messageDiggest);

        String hashText = no.toString(16);
        while (hashText.length() < 32) {
            hashText = "0" + hashText;
        }

        return hashText;
    }

    private boolean match(String password, String rawPassword)
            throws Exception {
        rawPassword = this.hash(rawPassword);
        return password.equals(rawPassword);
    }
    
}
    

