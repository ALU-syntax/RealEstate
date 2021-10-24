/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3;

import com.RealEstate.Kelompok2_3SC3.models.Customer;
import net.bytebuddy.utility.RandomString;
import static org.hamcrest.Matchers.containsString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 *
 * @author husen
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebMvcRegisterTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testRegisterWithRightCredentials() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Pendaftaran")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Hudya");
        customer.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("customer", customer))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    @Test
    public void testRegisterWithoutName() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Pendaftaran")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("");
        customer.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("customer", customer))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register"))
                .andExpect(MockMvcResultMatchers
                        .flash().attributeExists("danger")
                )
                .andExpect(
                        MockMvcResultMatchers
                                .flash()
                                .attribute("danger", "Name cannot be null!")
                );
    }
    
    @Test
    public void testRegisterWithoutPassword() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Pendaftaran")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Hudya");
        customer.setPassword("");

        mockMvc.perform(post("/register")
                .flashAttr("customer", customer))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/register"))
                .andExpect(MockMvcResultMatchers
                        .flash().attributeExists("danger")
                )
                .andExpect(
                        MockMvcResultMatchers
                                .flash()
                                .attribute("danger", "Password cannot be null!")
                );
    }
    
    @Test
    public void testRegisterThenLogin() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Pendaftaran")));
        
        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
       
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Hudya");
        customer.setPassword(password);

        mockMvc.perform(post("/register")
                .flashAttr("customer", customer))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));

        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Login")));

        
        Customer customerLogin = new Customer();
        customerLogin.setEmail(email);
        customerLogin.setPassword(password);
        
        mockMvc.perform(post("/login")
                .flashAttr("customer", customerLogin))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/"))
                .andDo(print());
    }
}
