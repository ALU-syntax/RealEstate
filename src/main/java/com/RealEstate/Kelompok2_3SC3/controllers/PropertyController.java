/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controllers;

import com.RealEstate.Kelompok2_3SC3.interfaces.CategoryInterface;
import com.RealEstate.Kelompok2_3SC3.models.Category;
import com.RealEstate.Kelompok2_3SC3.services.CategoryService;
import com.RealEstate.Kelompok2_3SC3.services.PropertyService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 *
 * @author macbook
 */
@Controller
public class PropertyController {
    
    @Autowired
    private CategoryInterface categoryInterface;
    
    @Autowired
    private PropertyService propertyService;
    
    @GetMapping("/detail-property")
    public String pageDetailProperty(){
    
        return "detail-property";
    }
    
    @GetMapping("/submit-property")
    public String pageSubmitProperty(Model model){
        
        List<Category> categories = categoryInterface.getAll();
        model.addAttribute("categories", categories);
    
        return "submit-property";
    }
    
    @PostMapping("/submit-property")
    public String saveProductBuy(Model model,@RequestParam("image") MultipartFile file,
                @RequestParam("image2") MultipartFile file2,
                @RequestParam("image3") MultipartFile file3,
                @RequestParam("image4") MultipartFile file4,
    		@RequestParam("title") String title,
    		@RequestParam("price") long price,
                @RequestParam("customer_id") long customerId,
                @RequestParam("area") long area,
                @RequestParam("bedroom") long bedroom,
                @RequestParam("city") String city,
                @RequestParam("bathroom") long bathroom,
                @RequestParam("desc") String desc)
    {
        
        List<Category> categories = categoryInterface.getAll();
        model.addAttribute("categories", categories);
        
        Category category = new Category();
        long categoryId = (long) category.getId();
        
        propertyService.saveProductToDB(file, file2, file3, file4, title, price,
                categoryId, customerId, area, bedroom, city, bathroom, desc);
    	
    	return "redirect:/profile";
    }
    
}
