/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.controller;

import com.sf.entity.Contact;
import com.sf.model.ContactsWrapper;
import com.sf.repository.ContactRepository;
import com.sf.repository.test.TestRepository;
import com.sf.service.ContactService;
import com.sf.service.ContactServiceTestConfig;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

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
