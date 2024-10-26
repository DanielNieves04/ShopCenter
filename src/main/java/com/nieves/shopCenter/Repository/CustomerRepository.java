/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.nieves.shopCenter.Repository;

import com.nieves.shopCenter.Entity.Customer;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Funciona con convencion de nomenclatura
//JpaRepository me brinda de manera facil consultas que normalmente se hacen en sql 
@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {//Long es el tipo de dato de la PK(primaryKey)
    Optional<Customer> findByFirstName(String firstName);
    
    //keywor
    List<Customer> findByFirstNameContaining(String firstName);
    List<Customer> findByLastNameNotNull();
    List<Customer> findByAddress_City(String city);
    
    //Consultas con JPQL
    @Query("select c from Customer c where c.email= ?1") //?1 significa primer parametro del atributo de abajo, ?2 seria referencia al segundo paramentro 
    Customer getCustomerByEmailAddress(String email);
    
    @Query("select c.firstName from Customer c where c.email = ?1 ")
    String getCustomerFistNameByEmailAddress(String email);
    
    //Consultas nativas
    @Query(
            value = "select * from tbl_customer where email_address= ?1",
            nativeQuery = true
    )
    Customer getCustomerByEmailAddressNative(String email);
    
    @Query(
            value = "select * from tbl_customer where email_address= :emailAddress",
            nativeQuery = true
    )
    Customer getCustomerByEmailAddressNativeNameParam(@Param("emailAddress") String email);
    
    
    //Cuando actualizamos o eliminamos registros en una tabla de la base de datos:
    
    //@Transactional puede ser usanda en varios niveles, como capa de servicios para garantizar que todo se ejecute bien
    @Transactional//sirve para crear una transaccion y dentro de esta transaccion se maneje la modificación de datos y controlar que si ocurre un error se haga un rolback para que la bd quede intacta
    
    //@Modifying a nivel de clase repositorio, nada mas
    @Modifying//indicamos a springBoot que esta transaccion es de actualizado o borrado de registros
    @Query(
            value = "update tbl_customer set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    void updateCustomerNameByEmail(String name, String email);
    
}
