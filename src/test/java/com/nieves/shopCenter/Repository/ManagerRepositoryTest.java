/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nieves.shopCenter.Repository;

import com.nieves.shopCenter.Entity.Manager;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ManagerRepositoryTest {
    
    @Autowired
    private ManagerRepository managerRepository;
    
    public ManagerRepositoryTest() {
    }

    @Test
    public void findAllManager() {
        List<Manager> listManeger = managerRepository.findAll();
        System.out.println("listManeger=" + listManeger);
    }
    
}
