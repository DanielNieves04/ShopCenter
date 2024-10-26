/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nieves.shopCenter.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_order")//porque posgresql reconoce order como una función propia de ellos 
public class Order {
    
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "order_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long orderId;
    private String description;
    private Double price;
    
    //ManytoOne va desde la entidad hijo y es mas recomendable que OneToMany, porque se ahorra tiempo de procesamiento
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "local_id",
            referencedColumnName = "localId"
    )
    private Local local;
}
