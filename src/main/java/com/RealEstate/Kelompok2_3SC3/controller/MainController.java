/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controller;

import com.RealEstate.Kelompok2_3SC3.models.Property;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author macbook
 */
public class MainController {
    
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Property> listProperty = service.listAll();
        model.addAttribute("listInventories", listInventories);

        return "index";
    }
    
}
