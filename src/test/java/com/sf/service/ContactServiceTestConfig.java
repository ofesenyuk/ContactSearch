/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.service;

import com.sf.repository.ContactRepository;
import com.sf.repository.test.TestRepository;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author sf
 */
@Configuration
public class ContactServiceTestConfig {
    
    @Autowired
    private ContactRepository contactRepository;    
    
    @Bean
    ContactRepository contactRepository() {
        return Mockito.mock(ContactRepository.class);
    }

    @Bean
    ContactService contactService() {
        return new ContactService(contactRepository);
    }

    @Bean
    TestRepository testRepository() {
        return new TestRepository(contactRepository);
    }
}
