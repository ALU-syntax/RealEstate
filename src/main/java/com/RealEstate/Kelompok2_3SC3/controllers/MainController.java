/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controllers;

import com.RealEstate.Kelompok2_3SC3.models.Property;
import com.RealEstate.Kelompok2_3SC3.services.PropertyService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author macbook
 */
@Controller
public class MainController {
    
    @Autowired
    private PropertyService propertyService;
    
    @GetMapping("/")
    public String index(){
        
        return "index";
    }
    
    @GetMapping("/property")
    public String propertiesPage(Model model){
        List<Property> property = propertyService.getAll();
        model.addAttribute("property", property);
        
        return "property";
    }
    
    @GetMapping("/blog")
    public String propertyPage(){
    
        return "blog";
    }
    
    @GetMapping("/contact")
    public String propertyContact(){
        
        return "contact";
    }
    
    
}
