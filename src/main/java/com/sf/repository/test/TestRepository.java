/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.repository.test;

import com.sf.entity.Contact;
import com.sf.repository.ContactRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sf
 */
@Component
@Getter
public class TestRepository {
    private final ContactRepository repository;
    
    private final List<Contact> testData;

    @Autowired
    public TestRepository(ContactRepository repository) {
        this.repository = repository;
        testData = new ArrayList<>();
        testData.add(new Contact(1L, "Sasha"));
        testData.add(new Contact(2L, "Pasha"));
        testData.add(new Contact(3L, "Vova"));
        testData.add(new Contact(4L, "Bora"));
        testData.add(new Contact(5L, "Artur"));
    }
    
    @Transactional
    public void persistToDB() {
        testData.forEach(c -> repository.save(new Contact(null, c.getName())));
    }
}
