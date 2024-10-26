/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.nieves.shopCenter.Repository;

import com.nieves.shopCenter.Entity.Address;
import com.nieves.shopCenter.Entity.Customer;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

@SpringBootTest
public class CustomerRepositoryTest {
    
    public CustomerRepositoryTest() {
    }
    
    @Autowired
    CustomerRepository customerRepository;
    
    @Test
    public void saveCustomer(){
        Customer customer = Customer.builder()
                .firstName("Juan")
                .lastName("Benitez")
                .build();
        customerRepository.save(customer);
    }
    
    @Test
    public void saveCustomerWithAddressEmbedded(){
        Address address = Address.builder()
                .city("Pamplona")
                .mainStreet("carrera 3 # 3-32")
                .secondaryStreet("Via Nacional")
                .build();
        
        Customer customer = Customer.builder()
                .firstName("Tatiana")
                .lastName("Urbano")
                .email("Tatiana.urbano@nieves")
                .address(address)
                .build();
        customerRepository.save(customer);
    }
    
    
    @Test
    public void findCustomerByFirstName(){
        Customer customer = customerRepository.findByFirstName("Daniel").get();
        System.out.println("customer=" + customer);
    }
    
    @Test
    public void findAllCustomer(){
        List<Customer> customerList = customerRepository.findAll();
        System.out.println("customerList=" + customerList);
    }
    
    @Test
    public void findAllCustomerFirstNameCotaining(){
        List<Customer> customerList = customerRepository.findByFirstNameContaining("Da");
        System.out.println("customerList=" + customerList);
    }
    
    @Test
    public void findAllCustomerLastNameNotNull(){
        List<Customer> customerList = customerRepository.findByLastNameNotNull();
        System.out.println("customerList=" + customerList);
    }
    
    @Test
    public void findAllCustomerByAddressCity(){
        List<Customer> customerList = customerRepository.findByAddress_City("Pamplona");
        System.out.println("customerList=" + customerList);
    }
    
    @Test
    public void getCustomerByEmailAddress(){
        Customer customer =customerRepository.getCustomerByEmailAddress("Daniel.nieves@nieves");
        System.out.println("customer =" + customer);
    }
    
    @Test
    public void getCustomerFistNameByEmailAddress(){
        String firstName= customerRepository.getCustomerFistNameByEmailAddress("Daniel.nieves@nieves");
        System.out.println("firstName =" + firstName);
    }
    
    @Test
    public void getCustomerByEmailAddressNative(){
        Customer customer = customerRepository.getCustomerByEmailAddressNative("Daniel.nieves@nieves");
        System.out.println("customer =" + customer);
    }
    
    @Test
    public void getCustomerByEmailAddressNativeNameParam(){
        Customer customer = customerRepository.getCustomerByEmailAddressNativeNameParam("Daniel.nieves@nieves");
        System.out.println("customer =" + customer);
    }
    
    @Test
    public void updateCustomerNameByEmail(){
        customerRepository.updateCustomerNameByEmail("Danielaa", "Daniela.caseres@nieves");
    }
    
}
