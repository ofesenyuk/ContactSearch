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
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 *
 * @author sf
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {ContactServiceTestConfig.class, 
            HelloControllerTestConfig.class})
public class HelloControllerTest {
    @Autowired
    private ContactService contactService;
    @Autowired
    private HelloController helloController;
    @Autowired
    private TestRepository testRepository;
    
    private List<Contact> contacts;
    private ContactsWrapper contactsWrapper;
    
    public HelloControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        contacts = testRepository.getTestData();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContact method, of class HelloController.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        Long id = 1L;
        String name = "test";
        Contact expResult = new Contact(id, name);
        Mockito.when(contactService.getContact(Mockito.eq(id)))
                .thenReturn(expResult);
        Contact result = helloController.getContact(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactsRegular method, of class HelloController.
     */
    @Test
    public void testGetContactsRegularWOFilter() {
        System.out.println("testGetContactsRegularWOFilter");
        String nameFilter = "";
        ContactsWrapper expResult = new ContactsWrapper(contacts);
        Mockito.when(contactService.getContactsRegular(Mockito.eq(nameFilter)))
                .thenReturn(expResult);
        ContactsWrapper result = helloController.getContactsRegular(nameFilter);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactsRegular method, of class HelloController.
     */
    @Test
    public void testGetContactsRegularNotStartWith() {
        System.out.println("testGetContactsRegularNotStartWith");
        String nameFilter = "^A.*$";
        List<Contact> filteredContacts = contacts.stream()
                .filter(c -> !c.getName().startsWith("A"))
                .collect(Collectors.toList());        
        ContactsWrapper expResult = new ContactsWrapper(filteredContacts);
        Mockito.when(contactService.getContactsRegular(Mockito.eq(nameFilter)))
                .thenReturn(expResult);
        ContactsWrapper result = helloController.getContactsRegular(nameFilter);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactsRegular method, of class HelloController.
     */
    @Test
    public void testGetContactsRegularDoesNotContain() {
        System.out.println("testGetContactsRegularDoesNotContain");
        String nameFilter = "^.*[aei].*$";
        List<Contact> filteredContacts = contacts.stream()
                .filter(c -> !c.getName().contains("a"))
                .filter(c -> !c.getName().contains("e"))
                .filter(c -> !c.getName().contains("i"))
                .collect(Collectors.toList());        
        ContactsWrapper expResult = new ContactsWrapper(filteredContacts);
        Mockito.when(contactService.getContactsRegular(Mockito.eq(nameFilter)))
                .thenReturn(expResult);
        ContactsWrapper result = helloController.getContactsRegular(nameFilter);
        assertEquals(expResult, result);
    }
    
}
