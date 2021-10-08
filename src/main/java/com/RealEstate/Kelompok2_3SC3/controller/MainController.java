/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controller;

import com.RealEstate.Kelompok2_3SC3.interfaces.PropertyInterface;
import com.RealEstate.Kelompok2_3SC3.models.Property;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macbook
 */
public class MainController {
    
    @Autowired
    private PropertyInterface propertyInterface;
    
    
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("property", propertyInterface.getAll());

        return "index";
    }
    
}
