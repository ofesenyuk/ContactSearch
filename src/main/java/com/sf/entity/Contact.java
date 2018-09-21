/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sf.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author OleksandrF
 */
@Entity
@Table(name = "contacts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
}
