package com.springSecuriy.springsecuritysec1.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    @GetMapping("/contact")
    public  String getContactDetail () {
        return "Here are the contact details from the DB";
    }

}