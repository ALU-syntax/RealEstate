/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controllers;

import com.RealEstate.Kelompok2_3SC3.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    
    @GetMapping("/detail-property")
    public String pageDetailProperty(){
        
        return "detail-property";
    }
}
