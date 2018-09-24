/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.service;

import com.sf.entity.Contact;
import com.sf.model.ContactsWrapper;
import com.sf.repository.ContactRepository;
import com.sf.repository.test.TestRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author sf
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {ContactServiceTestConfig.class})
public class ContactServiceTest {
    
    @Autowired
    private ContactRepository contactRepository;
    @Autowired
    private ContactService contactService;
    @Autowired
    private TestRepository testRepository;
    
    private List<Contact> contacts;
    

    public ContactServiceTest() {
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
        Mockito.when(contactRepository.findAllContacts())
                .thenReturn(CompletableFuture.supplyAsync(() -> contacts));
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getContact method, of class ContactService.
     */
    @Test
    public void testGetContact() {
        System.out.println("getContact");
        Long id = 1L;
        String name = "test";
        Contact expResult = new Contact(id, name);
        Mockito.when(contactRepository.findById(Mockito.eq(id)))
                .thenReturn(Optional.of(expResult));
        Contact result = contactService.getContact(id);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactsRegular method, of class ContactService.
     */
    @Test
    public void testGetContactsRegularWOFilter() {
        System.out.println("testGetContactsRegularWOFilter");
        String nameFilter = "";
        Mockito.when(contactRepository.findAllContacts())
                .thenReturn(CompletableFuture.supplyAsync(() -> contacts));
        ContactsWrapper expResult = new ContactsWrapper(contacts);
        ContactsWrapper result = contactService.getContactsRegular(nameFilter);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactsRegular method, of class ContactService.
     */
    @Test
    public void testGetContactsRegularNotStartWith() {
        System.out.println("testGetContactsRegularStartWith");
        String nameFilter = "^A.*$";
        ContactsWrapper result = contactService.getContactsRegular(nameFilter);
        List<Contact> filteredContacts = contacts.stream()
                .filter(c -> !c.getName().startsWith("A"))
                .collect(Collectors.toList());        
        ContactsWrapper expResult = new ContactsWrapper(filteredContacts);
        assertEquals(expResult, result);
    }

    /**
     * Test of getContactsRegular method, of class ContactService.
     */
    @Test
    public void testGetContactsRegularDoesNotContain() {
        System.out.println("testGetContactsRegularDoesNotContain");
        String nameFilter = "^.*[aei].*$";
        ContactsWrapper result = contactService.getContactsRegular(nameFilter);
        List<Contact> filteredContacts = contacts.stream()
                .filter(c -> !c.getName().contains("a"))
                .filter(c -> !c.getName().contains("e"))
                .filter(c -> !c.getName().contains("i"))
                .collect(Collectors.toList());        
        ContactsWrapper expResult = new ContactsWrapper(filteredContacts);
        assertEquals(expResult, result);
    }
    
}
