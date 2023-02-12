package com.customer.customer.customers;

import com.customer.customer.exception.NotFoundException;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CustomerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @GetMapping
    List<Customer> getCustomers(){
        LOGGER.info("getCustomers was called");
        return customerRepository.findAll();
    }
    @GetMapping
    Customer getCustomer(Long id){

        return customerRepository.findById(id)
                .orElseThrow(
                        () -> {
                    NotFoundException notFoundException = new NotFoundException(
                            "customer " + id + " not found");
                    LOGGER.error("error in getting customer {}", id, notFoundException);
                    return notFoundException;
                });
    }
    @PostMapping
    public void addNewCustomer(Customer customer){
        Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(customer.getEmail());
         if(customerOptional.isPresent()){
             throw new IllegalStateException("Email Taken");
         }
         customerRepository.save(customer);
    }
    @DeleteMapping
    public void deleteCustomer(Long customerId) {
        boolean exists = customerRepository.existsById(customerId);
        if (!exists){
            throw new IllegalStateException("customer with id "+ customerId + " does not exists");
        }
        customerRepository.deleteById(customerId);

    }
    @Transactional
    public void updateCustomer(Long customerId, String name, String email, String password) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() ->
                new IllegalStateException("student with id " + customerId +" does not exists"));
        if(name != null &&
                name.length() > 0 && !Objects.equals(customer.getName(),name)){
            customer.setName(name);
        }
        if (email != null &&
                email.length() > 0 && !Objects.equals(customer.getEmail(), email)){
            Optional<Customer> customerOptional = customerRepository.findCustomerByEmail(email);
            if (customerOptional.isPresent()){
                throw new IllegalStateException("email taken");
            }
            customer.setEmail(email);
        }
        if (password != null &&
                password.length() > 0 && !Objects.equals(customer.getPassword(), password)) {
            Optional<Customer>  customerOptional = customerRepository.findCustomerByEmail(email);
            if(customerOptional.isPresent()){
                customer.setPassword(password);
            }
        }
    }

}
