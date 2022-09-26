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
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/accounts/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id){
        return new ResponseEntity(accountRepository.findById(id), HttpStatus.OK);
    }


    @PostMapping("/accounts")
    public ResponseEntity<Account> postCourse(@RequestBody Account account){
        accountRepository.save(account);
        return new ResponseEntity<>(account, HttpStatus.CREATED);
    }

    @PutMapping(value="/accounts/{id}")
    public ResponseEntity<Account> putCourse(@RequestBody Account account, @PathVariable Long id){
        Account accountToUpdate = accountRepository.findById(id).get();
        accountToUpdate.setNumber(account.getNumber());
        accountToUpdate.setType(account.getType());
        return new ResponseEntity<>(accountToUpdate, HttpStatus.OK);
    }

    @DeleteMapping(value="/accounts/{id}")
    public ResponseEntity<Long> deleteAccount(@PathVariable Long id){
        accountRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping(value="/accounts/{id}/customers")
    public ResponseEntity<List<Customer>> getCustomerForAccount(@PathVariable Long id,
                                                                @RequestParam(name = "userName", required = false) String userName,
                                                                @RequestParam(name = "email", required = false) String email,
                                                                @RequestParam(name = "address", required = false) String address,
                                                                @RequestParam(name = "name", required = false) String name) {
        if (name != null){
            if (email != null){
                if(address != null){
                    if(userName != null){
                        return new ResponseEntity<>(customerRepository.findAllByNameAndByEmailAndByUserNameAndByAddress(name, email, userName, address), HttpStatus.OK);
                    }
                    return new ResponseEntity<>(customerRepository.findAllByNameAndByEmailAndByUserName(name, email, userName), HttpStatus.OK);
                }
                return new ResponseEntity<>(customerRepository.findAllByNameAndByEmail(name, email), HttpStatus.OK);
            }
            return new ResponseEntity<>(customerRepository.findAllByName(name), HttpStatus.OK);
        }

        return new ResponseEntity<>(customerRepository.findAllByCustomerId(id), HttpStatus.OK);
    }
    @GetMapping(value = "/accounts/{type}")
    public ResponseEntity<Account> getAccountByType(@PathVariable String type){
        return new ResponseEntity(accountRepository.findAllByType(type), HttpStatus.OK);
    }

    @GetMapping(value = "/accounts/{number}")
    public ResponseEntity<Account> getAccountByNumber(@PathVariable Long number){
        return new ResponseEntity(accountRepository.findAllByNumber(number), HttpStatus.OK);
    }
}
