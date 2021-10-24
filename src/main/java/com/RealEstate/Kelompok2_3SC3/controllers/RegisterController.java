/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controllers;

import com.RealEstate.Kelompok2_3SC3.interfaces.CustomerInterface;
import com.RealEstate.Kelompok2_3SC3.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author macbook
 */
@Controller
public class RegisterController {
    
    @Autowired
    private CustomerInterface customerInterface;

    @GetMapping("/register")
    public String index(Model model) {

        Customer customer = new Customer();
        model.addAttribute("customer", customer);

        return "register";
    }

    @PostMapping("/register")
    public String store(@ModelAttribute("customer") Customer customer, RedirectAttributes ra) throws Exception {
        
        if (customer.getName().equals("")) {
            ra.addFlashAttribute("danger", "Name cannot be null!");
            return "redirect:/register";
        }
        
        if (customer.getPassword().equals("")) {
            ra.addFlashAttribute("danger", "Password cannot be null!");
            return "redirect:/register";
        }
        
        customerInterface.register(customer);
        return "redirect:/login";
    }
    
}
