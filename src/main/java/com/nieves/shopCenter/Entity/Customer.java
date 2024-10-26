/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nieves.shopCenter.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "tbl_customer",
        uniqueConstraints = @UniqueConstraint(
                name = "email_unique",
                columnNames = "email_address "
        )
)
public class Customer {
    
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1 //Tomamos el valor uno porque por la practica no vamos a usar muchos clientes
    )
    @GeneratedValue(
            generator = "customer_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long customerId;
    private String firstName;
    private String lastName;
    
    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;
    
    
//    private String customerCity;
//    private String customerMainStreet;
//    private String customerSecondaryStreet;
    
    //Me permite incrustar una entidad
    @Embedded
    private Address address;
}
