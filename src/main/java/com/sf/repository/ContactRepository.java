/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.repository;

import com.sf.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 *
 * @author sf
 */
public interface ContactRepository  extends JpaRepository<Contact, Long> {
    
}
