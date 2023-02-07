package com.customer.customer.customers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v3/customers")
public class CustomerControllerV3 {
    private final CustomerService customerService;

    @Autowired
    public CustomerControllerV3(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    List<Customer> getCustomers(){
        return customerService.getCustomers();
    }
    @GetMapping(path ="{customerId}")
    Customer getCustomerException(@PathVariable("customerId") Long id) {
         return customerService.getCustomer(id);
    }
    @PostMapping
    void createNewCustomer(@Valid @RequestBody Customer customer){
        customerService.addNewCustomer(customer);
    }
    @PutMapping(path = "{customerId}")
    void updateCustomer(@PathVariable("customerId") Long customerId,
                        @RequestParam(required = false) String name,
                        @RequestParam(required = false) String email,
                        @RequestParam(required = false )String password){
        customerService.updateCustomer(customerId,name,email,password);
    }
    @DeleteMapping(path ="{customerId}")
    void deleteCustomer(@PathVariable("customerId") Long id){
        customerService.deleteCustomer(id);
    }
}
