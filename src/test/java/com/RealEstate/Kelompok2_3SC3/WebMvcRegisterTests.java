/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3;

import com.RealEstate.Kelompok2_3SC3.models.Customer;
import java.util.HashMap;
import java.util.Random;
import net.bytebuddy.utility.RandomString;
import org.h2.util.MathUtils;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
                .andExpect(content().string(containsString("Home")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Minan");
        customer.setPassword(password);
        customer.setAddress("Jalan Uhuy");
        customer.setBirthday("24/12/21");
        customer.setNik(4431230);
        customer.setImage("foto cantik");
        customer.setNumberPhone(07321242);

        mockMvc.perform(post("/register")
                .flashAttr("customer", customer))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"));
    }

    @Test
    public void testRegisterWithoutName() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Home")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("");
        customer.setPassword(password);
        customer.setBirthday("22/04/06");
        customer.setAddress("Sepanjang jalan kenangan");
        customer.setNik(1104620023);
        customer.setNumberPhone(1238123);
        customer.setImage("Foto Ganteng");
        
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
                .andExpect(content().string(containsString("Home")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Minan");
        customer.setPassword("");
        customer.setAddress("Jalanin aja");
        customer.setNik(2192134);
        customer.setNumberPhone(624729132);
        customer.setBirthday("05/05/04");
        customer.setImage("Gambar Bagus");

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
    public void testRegisterWithoutBirthday() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Home")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Hudya");
        customer.setBirthday("");
        customer.setAddress("jalanankita");
        customer.setNumberPhone(00000);
        customer.setNik(2100921);
        customer.setImage("monokorobo");
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
                                .attribute("danger", "Birthday cannot be null!")
                );
    }
    
    @Test
    public void testRegisterWithoutAddress() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Home")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Ardian");
        customer.setBirthday("20201222");
        customer.setAddress("");
        customer.setNumberPhone(00000);
        customer.setPassword(password);
        customer.setNik(123812);
        customer.setImage("Image Uhuy");

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
                                .attribute("danger", "Address cannot be null!")
                );
    }
    
    @Test
    public void testRegisterThenLogin() throws Exception {
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Home")));
        
        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
       
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Minan");
        customer.setPassword(password);
        customer.setAddress("jalanin aja");
        customer.setBirthday("22/04/06");
        customer.setNik(47123931);
        customer.setNumberPhone(01234567);
        customer.setImage("foto kodok");
        

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
    
    @Test
    public void testRegisterThenLoginThenLogout() throws Exception {
        Random rndm = new Random();
        String SALTCHARS = "1234567890";
        StringBuilder salt = new StringBuilder();
        while (salt.length() < 14) { // length of the random string.
            int index = (int) (rndm.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Home New account / Sign in")));

        String email = RandomString.make(10).toLowerCase() + "@mail.com";
        String password = RandomString.make(10).toLowerCase();
        
        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setName("Jaber");
        customer.setPassword(password);
        customer.setAddress("jalan mana weh");
        customer.setBirthday("22/04/06");
        customer.setNik(47123931);
        customer.setNumberPhone(01234567);
        customer.setImage("foto kodok");
       
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
        
        HashMap<String, Object> sessionattr = new HashMap<String, Object>();
        
        sessionattr.put("id", customer.getId());
        sessionattr.put("email", customer.getEmail());
        sessionattr.put("name", customer.getName());
        sessionattr.put("loggedIn", true);
                
        
        mockMvc.perform(get("/logout")
                .sessionAttrs(sessionattr))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login"))
                .andDo(print());
        
        sessionattr.remove("id");
        sessionattr.remove("email");
        sessionattr.remove("name");
        sessionattr.remove("loggedIn");
    }
}
