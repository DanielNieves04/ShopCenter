/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nieves.shopCenter.Repository;

import com.nieves.shopCenter.Entity.Local;
import com.nieves.shopCenter.Entity.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderRepositoryTest {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public OrderRepositoryTest() {
    }
    
    @Test
    public void saveOrder(){
        
        Local local = Local.builder()
                .name("Binco")
                .floor("Fourth floor")
                .build();
        
        Order order= Order.builder()
                .description("Camiseta de tirantes blanca")
                .price(4.0)
                .local(local)
                .build();
        
        orderRepository.save(order);
    }
}
