/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nieves.shopCenter.Entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//No se utiliza @Entity porque es una entidad que va ser incrustada dentro de otra
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Me permite incrustar esta entidad en otras
@Embeddable
//Asignamos los atributos a unos que ya se habian creado, para evitar duplicar atributos
@AttributeOverrides({
    @AttributeOverride(
     name = "city",
     column = @Column(name = "customer_city")
    ),
    @AttributeOverride(
     name = "mainStreet",
     column = @Column(name = "customer_main_street")
    ),
    @AttributeOverride(
     name = "secondaryStreet",
     column = @Column(name = "customer_secondary_street")
    )
})
public class Address {
    private String city;
    private String mainStreet;
    private String secondaryStreet;
}
