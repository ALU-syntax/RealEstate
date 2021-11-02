/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3;

import com.RealEstate.Kelompok2_3SC3.models.Property;
import com.RealEstate.Kelompok2_3SC3.repositories.PropertyRepository;
import com.RealEstate.Kelompok2_3SC3.services.PropertyService;
import java.io.IOException;
import java.util.Base64;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author husen
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PropertyTests {
    @InjectMocks
    @Autowired
    PropertyService service;
    
    @Mock
    PropertyRepository repositiries;
    
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreateProperty() throws Exception{
        Property property = new Property();
        property.setTitle("rumah");
        property.setPrice(5000);
        property.setCategoryId(1);
        property.setCustomerId(2);
        property.setArea(1000);
        property.setBedroom(6);
        property.setCity("jakarta");
        property.setBathroom(3);
        property.setDesc("Mantap");
        property.setImage("pabrik");
        property.setImage2("pabrik 2");
        property.setImage3("pabrik 3");
        property.setImage4("pabrik 4");
        
        mockMvc.perform(post("/submit-property")
                .flashAttr("property", property))
                .andExpect(status().is3xxRedirection());
    }
    @Test
    public void CreatePropertyWithoutTitle(MultipartFile file, String title, long price,
            long categoryId, long customerId, long area, long bedroom, 
            String city, long bathroom, String desc) throws Exception{
         Throwable e = null;
        String message = null;
        
        try {
        Property property = new Property();
        property.setTitle("");
        property.setPrice(5000);
        property.setCategoryId(1);
        property.setCustomerId(2);
        property.setArea(1000);
        property.setBedroom(6);
        property.setCity("jakarta");
        property.setBathroom(3);
        property.setDesc("Mantap");
        property.setImage("pabrik");
        property.setImage2("pabrik 2");
        property.setImage3("pabrik 3");
        property.setImage4("pabrik 4");
        
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			property.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
        
        title = property.getTitle();
        price = property.getPrice();
        categoryId = property.getCategoryId();
        customerId = property.getCustomerId();
        area = property.getArea();
        bedroom = property.getBedroom();
        city = property.getCity();
        bathroom = property.getBathroom();
        desc = property.getDesc();

            when(repositiries.save(property))
                    .thenThrow(new Exception("please fill out this field"));
            service.saveProductToDB(fileName, title, price, categoryId, customerId, area, bedroom, city, bathroom, desc);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
}
    @Test
    public void CreatePropertyWithoutCity() throws Exception{
         Throwable e = null;
        String message = null;
        
        try {
        Property property = new Property();
        property.setTitle("rumah");
        property.setPrice(5000);
        property.setCategoryId(1);
        property.setCustomerId(2);
        property.setArea(1000);
        property.setBedroom(6);
        property.setCity("");
        property.setBathroom(3);
        property.setDesc("Mantap");
        property.setImage("pabrik");
        property.setImage2("pabrik 2");
        property.setImage3("pabrik 3");
        property.setImage4("pabrik 4");

            when(repositiries.save(property))
                    .thenThrow(new Exception("please fill out this field"));
            service.save(property);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
}
    
   @Test
    public void CreatePropertyWithoutDesc() throws Exception{
         Throwable e = null;
        String message = null;
        
        try {
        Property property = new Property();
        property.setTitle("rumah");
        property.setPrice(5000);
        property.setCategoryId(1);
        property.setCustomerId(2);
        property.setArea(1000);
        property.setBedroom(6);
        property.setCity("jakarta");
        property.setBathroom(3);
        property.setDesc("");
        property.setImage("pabrik");
        property.setImage2("pabrik 2");
        property.setImage3("pabrik 3");
        property.setImage4("pabrik 4");

            when(repositiries.save(property))
                    .thenThrow(new Exception("please fill out this field"));
            service.save(property);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
}
    @Test
    public void CreatePropertyWithoutImage() throws Exception{
         Throwable e = null;
        String message = null;
        
        try {
        Property property = new Property();
        property.setTitle("rumah");
        property.setPrice(5000);
        property.setCategoryId(1);
        property.setCustomerId(2);
        property.setArea(1000);
        property.setBedroom(6);
        property.setCity("jakarta");
        property.setBathroom(3);
        property.setDesc("mantap");
        property.setImage("");
        property.setImage2("pabrik 2");
        property.setImage3("pabrik 3");
        property.setImage4("pabrik 4");

            when(repositiries.save(property))
                    .thenThrow(new Exception("please fill out this field"));
            service.save(property);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
}
}

    
