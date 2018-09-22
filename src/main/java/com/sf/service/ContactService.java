/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.service;

import com.sf.entity.Contact;
import com.sf.model.ContactsWrapper;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sf.repository.ContactRepository;
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
    
    public Contact getContact(Long id) {
        return contactRepository.findById(id).orElse(null);
    }

    public ContactsWrapper getContactsRegular(String nameFilter) {
        Future<List<Contact>> future = contactRepository.findAllContacts();
        List<Contact> contacts = Collections.emptyList();
        try {
            contacts = future.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ContactService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        final List<Contact> filteredContacts = contacts.stream()
                .filter(c -> !c.getName().matches(nameFilter))
                .collect(Collectors.toList());
        ContactsWrapper contactsWrapper = new ContactsWrapper(filteredContacts);
        return contactsWrapper;
    }
    
}
