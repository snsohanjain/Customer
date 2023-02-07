package com.customer.customer.customers;


import java.util.Arrays;
import java.util.List;
@Deprecated
public class CustomerFakeRepository implements CustomerRepo {

    @Override
    public List<Customer> getAllCustomers() {
        return Arrays.asList(
                new Customer(1L,"SOHANJAIN","PASSWORD","email@gmail.com"),
                new Customer(2L,"NITHINJAIN","PASSWORD","email@gmail.com"),
                new Customer(3L,"JAYANTHJAIN","PASSWORD","email@gmail.com")
        );
    }
}
