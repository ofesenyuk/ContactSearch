/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.controller;

import com.sf.entity.Contact;
import com.sf.model.ContactsWrapper;
import com.sf.service.ContactService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author OleksandrF
 */
@RestController
@RequestMapping(value = "/hello")
public class HelloController {
    
    private final ContactService contactService;

    @Autowired
    public HelloController(ContactService contactService) {
        this.contactService = contactService;
    }
    
    @GetMapping(value = "/contact/{id}")
    public Contact getContact(@PathVariable("id") Long id) {
        return contactService.getContact(id);
    }
    
    @GetMapping(value = "/contacts")
    public ContactsWrapper getContactsRegular(
            @RequestParam("nameFilter") String nameFilter
    ) {
        return contactService.getContactsRegular(nameFilter);
    }
}
