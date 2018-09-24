/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.controller;

import com.sf.service.ContactService;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author sf
 */
@Configuration
public class HelloControllerTestConfig {
    
    @Autowired
    private ContactService contactService;
    
    @Bean
    ContactService contactService() {
        return Mockito.mock(ContactService.class);
    }
    
    @Bean
    HelloController helloController() {
        return new HelloController(contactService);
    }
    
}
