package com.customer.customer.customers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Deprecated
@Configuration
public class CustomerConfiguration {

//    --app.useFakeCustomerRepo=false
//    @Value("${app.useFakeCustomerRepo:false}")
//    private Boolean useFakeCustomerRepo;
//
//    @Bean
//    CommandLineRunner commandLineRunner(){
//        return args -> {
//            System.out.println("Command line runner hooray");
//        };
//    }
//    @Bean
//    CustomerRepo customerRepo(){
//        System.out.println("useFakeCustomerRepo = " + useFakeCustomerRepo);
//        return new CustomerFakeRepository();
//
//
//    }
}
