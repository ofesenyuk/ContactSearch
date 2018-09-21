/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.service;

import com.sf.entity.Contact;
import com.sf.repository.ContactRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//import reactor.core.publisher.Mono;

/**
 *
 * @author OleksandrF
 */
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }
    
    @Transactional
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public List<Contact> getContactsRegular(String nameFilter) {
        return contactRepository.findAll()
                .stream()
                .filter(c -> !c.getName().matches(nameFilter))
                .collect(Collectors.toList());
    }
    
}
