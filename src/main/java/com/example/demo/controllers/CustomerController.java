package com.example.demo.controllers;

import com.example.demo.models.Account;
import com.example.demo.models.Customer;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    AccountRepository accountRepository;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Long id) {
        return new ResponseEntity(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<Customer> putCustomer(@RequestBody Customer customer, @PathVariable Long id){
        Customer foundCustomer = customerRepository.findById(id).get();
        foundCustomer.setName(customer.getName());
        foundCustomer.setAddress(customer.getAddress());
        foundCustomer.setEmail(customer.getEmail());
        foundCustomer.setPassword(customer.getPassword());
        customerRepository.save(foundCustomer);
        return new ResponseEntity<>(foundCustomer, HttpStatus.OK);
    }
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> deleteCustomer(@PathVariable Long id){
        customerRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{customerId}/accounts")
    public ResponseEntity<List<Account>> getAccountsForCustomer(@PathVariable Long customerId) {
        return new ResponseEntity<>(accountRepository.findAllByCustomerId(customerId), HttpStatus.OK);
    }

}
