/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author macbook
 */
@Controller
public class PropertyController {
 
    
    @GetMapping("/submit-property")
    public String pageSubmitProperty(){
        
        return "submit-property";
    }
}
