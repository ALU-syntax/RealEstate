/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3;

import com.RealEstate.Kelompok2_3SC3.models.Customer;
import com.RealEstate.Kelompok2_3SC3.repositories.CustomerRepository;
import com.RealEstate.Kelompok2_3SC3.services.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author husen
 */
@SpringBootTest
public class CustomerIntegrationTests {

    @InjectMocks
    @Autowired
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    public void createCustomerTest() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("minan@mail.com");
        customer.setAddress("jalann");
        customer.setBirthday("20201112");
        customer.setName("minna");
        customer.setPassword("password");

        when(customerRepository.save(customer)).thenReturn(customer);
        customerService.register(customer);

        when(customerRepository.findByEmail("minan@husen.com")).thenReturn(customer);

        Customer checkCustomer = this.customerRepository.findByEmail("minan@husen.com");

        Assertions.assertEquals(customer, checkCustomer);
    }

    @Test
    public void createCustomerTestWithEmptyName() throws Exception {
        Customer customer = new Customer();
        customer.setEmail("minan@husen.com");
        customer.setAddress("jalann");
        customer.setBirthday("20201112");
        customer.setName("");
        customer.setPassword("password");

        when(customerRepository.save(customer)).thenReturn(customer);
        customerService.register(customer);

        when(customerRepository.findByEmail("minan@husen.com")).thenReturn(customer);

        Customer checkCustomer = this.customerRepository.findByEmail("minan@husen.com");

        Assertions.assertEquals(customer, checkCustomer);
    }

    @Test
    public void createCustomerTestWithEmptyEmail() throws Exception {

        Throwable e = null;
        String message = null;

        try {
            Customer customer = new Customer();
            customer.setEmail("");
            customer.setAddress("jalann");
            customer.setBirthday("20201112");
            customer.setName("minna");
            customer.setPassword("password");

            when(customerRepository.save(customer))
                    .thenThrow(new Exception("Email cannot be null!"));
            
            customerService.register(customer);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }

        Assertions.assertTrue(e instanceof Exception);
//        Assertions.assertEquals("Email cannot be null!", message);
    }

}