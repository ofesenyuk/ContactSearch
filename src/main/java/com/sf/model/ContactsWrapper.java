/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.model;

import com.sf.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 *
 * @author sf
 */
@Data
@AllArgsConstructor
public class ContactsWrapper {
    private final List<Contact> contacts;
}
