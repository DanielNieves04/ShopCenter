/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nieves.shopCenter.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "manager") // necesaria para ejecutar fetch = FetchType.LAZY // tambien necesaria para la bidireccionalidad
public class Local {
    
    @Id
    @SequenceGenerator(
            name = "local_sequence",
            sequenceName = "local_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "local_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long localId;
    private String name;
    private String floor;
    
    @OneToOne(
            cascade = CascadeType.PERSIST,//cualquier acción que se realice en la entidad principal se propagará automáticamente a la entidad asociada
            //fetch = FetchType.LAZY //con esta opción se obtiene solo la información de la clase padre (en este caso de local) 
            fetch = FetchType.EAGER, //con esta opción se obtiene la informacion de la clase padre y clase hijo // Esta viene por defecto
            //optional = false // Asi hacemos que para cear un local es obligatorio asignarle un manager
            optional = true
    )
    @JoinColumn(
            name = "fk_Manager_id",
            referencedColumnName = "managerId"
    )
    private Manager manager;
    
    
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name= "local_customer_map",
            joinColumns = @JoinColumn(
                    name = "local_id",
                    referencedColumnName = "localId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name="customer_id",
                    referencedColumnName = "customerId"
            )
    )
    private List<Customer> customerList;
    
//    @OneToMany(
//            cascade = CascadeType.PERSIST,
//            fetch = FetchType.EAGER
//    )
//    @JoinColumn(
//            name = "local_id",
//            referencedColumnName = "localId"
//    )
//    private List<Order> orderList;
}
