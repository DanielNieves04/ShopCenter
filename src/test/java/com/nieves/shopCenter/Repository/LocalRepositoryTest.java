/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nieves.shopCenter.Repository;

import com.nieves.shopCenter.Entity.Customer;
import com.nieves.shopCenter.Entity.Local;
import com.nieves.shopCenter.Entity.Manager;
import com.nieves.shopCenter.Entity.Order;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LocalRepositoryTest {
    
    @Autowired
    private LocalRepository localRepository;
    
    public LocalRepositoryTest() {
    }

    @Test
    public void saveLocal() {
        Manager manager = Manager.builder()
                .firstName("Daniel")
                .lastName("Nieves")
                .build();
        
        Local local = Local.builder()
                .name("PetShop")
                .floor("Second Floor")
                .manager(manager)
                .build();
        localRepository.save(local);
    }
    
    @Test
    public void findAllLocals(){
        List<Local> localList = localRepository.findAll();
        System.out.println("LocalList=" + localList);
    }
    
    @Test
    public void deleteLocal(){
        localRepository.deleteById(Long.parseLong("3"));
    }
    
    @Test
    public void SaveLocalWithOrders(){
        
        Manager manager = Manager.builder()
                .firstName("Tatiana")
                .lastName("Nieves")
                .build();
        
        Order order1 = Order.builder()
                .description("Entrada pelicula 1")
                .price(6.0)
                .build();
        
        Order order2 = Order.builder()
                .description("Entrada pelicula 2")
                .price(8.0)
                .build();
        
        Local local = Local.builder()
                .name("Cinema")
                .floor("Third Floor")
                .manager(manager)
                //.orderList(List.of(order1,order2))
                .build();
        
        localRepository.save(local);
    }
    
    @Test
    public void findLocalWithCustomer(){
        Customer customer1= Customer.builder()
                .firstName("Gustavo")
                .lastName("Medina")
                .email("gustavo@nieves")
                .build();
        
        Customer customer2 = Customer.builder()
                .firstName("Mario")
                .lastName("Cuevas")
                .email("mario@nieves")
                .build();
        
        Local local=Local.builder()
                .name("Restaurant")
                .floor("First Floor")
                .customerList(List.of(customer1,customer2))
                .build();
        
        localRepository.save(local);
    }
    
    //No es recomendable en un proyecto real
    @Test
    public void FindAllLocalsWithCustomer(){
        List<Local> localList = localRepository.findAll();
        System.out.println("localList =" + localList);
    }
    
    
    //Es mas recomendable
    @Test
    public void findCustomerByLocal(){
        Local local = localRepository.findById(7L).get();
        List<Customer> customerList = local.getCustomerList();
        System.out.println("customerList = " + customerList);
    }
}
