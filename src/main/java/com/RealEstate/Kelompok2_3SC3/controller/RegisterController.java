/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controller;

import com.RealEstate.Kelompok2_3SC3.interfaces.CustomerInterface;
import com.RealEstate.Kelompok2_3SC3.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author macbook
 */
@Controller
public class RegisterController {
    
    @GetMapping("/register")
    public String register(){
    
        return "register";
    }
    
    @Autowired
    private CustomerInterface customerInterface;

    @GetMapping("/register")
    public String index(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "register";
    }

    @PostMapping("/register")
    public String store(@ModelAttribute("customer") Customer customer) throws Exception {
        customerInterface.register(customer);
        return "redirect:/login";
    }

    
}
