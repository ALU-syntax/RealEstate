/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3;

import com.RealEstate.Kelompok2_3SC3.models.Customer;
import com.RealEstate.Kelompok2_3SC3.models.Property;
import com.RealEstate.Kelompok2_3SC3.repositories.PropertyRepository;
import com.RealEstate.Kelompok2_3SC3.services.PropertyService;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockMultipartFile;
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
    
    @MockBean
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
    public void CreatePropertyWithoutTitle() throws Exception{
         try{
            MultipartFile image = new MockMultipartFile("file", "test-file.txt",
                "text/plain" , "Green Learner - Arvind".getBytes());
            Mockito.doThrow(IllegalStateException.class)
                    .when(service)
                    .saveProductToDB(image,anyString(),anyInt(),anyInt(),
                            anyInt(),anyInt(),anyInt(),anyString(),anyInt(),anyString());

            service.saveProductToDB(image, null, 1000000, 1, 2, 2120, 4, "Jakarta",
                    8, "Pokoknya bagus dah");
        }catch(Exception e){
            Assertions.assertTrue(e instanceof Exception);
        }
        
}

    //Create Without City
    @Test
    public void CreatePropertyWithoutCity() throws Exception{
         try{
            MultipartFile image = new MockMultipartFile("file", "test-file.txt",
                "text/plain" , "Green Learner - Arvind".getBytes());
            Mockito.doThrow(IllegalStateException.class)
                    .when(service)
                    .saveProductToDB(image,anyString(),anyInt(),anyInt(),
                            anyInt(),anyInt(),anyInt(),anyString(),anyInt(),anyString());

            service.saveProductToDB(image, "Villa Bogor Indah", 1000000, 1, 2, 2120, 4, null,
                    8, "Pokoknya bagus dah");
        }catch(Exception e){
            Assertions.assertTrue(e instanceof Exception);
        }
}
 
    //Create Property Without Desc
   @Test
    public void CreatePropertyWithoutDesc() throws Exception{
         try{
            MultipartFile image = new MockMultipartFile("file", "test-file.txt",
                "text/plain" , "Green Learner - Arvind".getBytes());
            Mockito.doThrow(IllegalStateException.class)
                    .when(service)
                    .saveProductToDB(image,anyString(),anyInt(),anyInt(),
                            anyInt(),anyInt(),anyInt(),anyString(),anyInt(),anyString());

            service.saveProductToDB(image, "Villa Bogor Indah", 1000000, 1, 2, 2120, 4, "Bogor",
                    8, null);
        }catch(Exception e){
            Assertions.assertTrue(e instanceof Exception);
        }
    }
    
    //Delete
    @Test
    public void DeleteBuyProduct(){
        
        Property property = new Property();
        property.setId(1);
        
        long id = property.getId();
        doNothing().when(repositiries).deleteById(id);
        service.delete(id);
        
        verify(repositiries, times(1)).deleteById(id);
    }
    
//    Edit
    @Test
    public void TestUsingUpdateMethod() throws Exception {
        
        MultipartFile image = new MockMultipartFile("file", "test-file.txt",
            "text/plain" , "Property Villa Puncak Uhuy".getBytes());
        
        
        Property property = new Property();
        property.setImage(image.getOriginalFilename());
        property.setTitle("Villa Uhuy");
        property.setPrice(2000000000);
        property.setCategoryId(1);
        property.setCustomerId(1);
        property.setArea(4020);
        property.setBedroom(4);
        property.setCity("Bogor");
        property.setBathroom(4);
        property.setDesc("Ajib dah pokoknya");
        property.setId(1);
        
        
        when(repositiries.save(property)).thenReturn(property);
        service.updateProductToDB(image, 1, "Villa Uhuy", 2000000000, 1,1,
                4020, 4, "Bogor", 4, "Ajib dah pokoknya");
        
        List<Property> listProperty = Arrays.asList(property);

        when(repositiries.findByCustomerId(1)).thenReturn(listProperty);
        List<Property> property2 = service.findByCustomerId(1);
        
        Assertions.assertEquals(Arrays.asList(property), property2);
        
    }
}
    
