package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
@Controller
@CrossOrigin
public class Loginto {
    @RequestMapping("/defult")
    public String page(HttpServletRequest request)
    {
        return "redirect:http://localhost/admin/updateProfile.html";
    }
}
