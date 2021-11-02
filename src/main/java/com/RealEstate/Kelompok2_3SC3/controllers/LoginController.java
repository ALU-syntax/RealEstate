/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.RealEstate.Kelompok2_3SC3.controllers;

import com.RealEstate.Kelompok2_3SC3.interfaces.CustomerInterface;
import com.RealEstate.Kelompok2_3SC3.models.Customer;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author macbook
 */
@Controller
public class LoginController {
    
    @Autowired
    private CustomerInterface customerInterface;

    @GetMapping("/login")
    public String index(Model model) {

        Customer user = new Customer();
        model.addAttribute("customer", user);

        return "login";
    }

    @PostMapping("/login")
    public String store(@ModelAttribute("customer") Customer customer,
            HttpServletRequest request, RedirectAttributes ra) throws Exception {
        HttpSession session = request.getSession(true);

        Customer obj = customerInterface.auth(customer.getEmail(), customer.getPassword());

        if (obj == null) {
            ra.addFlashAttribute("error", "Invalid username or password!");
            return "redirect:/login";
        }

        session.setAttribute("id", obj.getId());
        session.setAttribute("email", obj.getEmail());
        session.setAttribute("name", obj.getName());
        session.setAttribute("loggedIn", true);

        return "redirect:/";
    }
    
}
