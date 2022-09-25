package com.example.demo.components;

import com.example.demo.models.Account;
import com.example.demo.models.Customer;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {

    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){}
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Account accountS1 = new Account(1234, "saving");
        accountRepository.save(accountS1);
        Account accountS2 = new Account(1235, "saving");
        accountRepository.save(accountS2);
        Account accountS3 = new Account(1236, "saving");
        accountRepository.save(accountS3);
        Account accountS4 = new Account(1237, "saving");
        accountRepository.save(accountS4);
        Account accountS5 = new Account(1238, "saving");
        accountRepository.save(accountS5);

        Account accountM1 = new Account(2234, "market");
        accountRepository.save(accountM1);
        Account accountM2 = new Account(2235, "market");
        accountRepository.save(accountM2);
        Account accountM3 = new Account(2236, "market");
        accountRepository.save(accountM3);
        Account accountM4 = new Account(2237, "market");
        accountRepository.save(accountM4);
        Account accountM5 = new Account(2238, "market");
        accountRepository.save(accountM5);


        Account accountB1 = new Account(3234, "brokerage");
        accountRepository.save(accountB1);
        Account accountB2 = new Account(3235, "brokerage");
        accountRepository.save(accountB2);
        Account accountB3 = new Account(3236, "brokerage");
        accountRepository.save(accountB3);
        Account accountB4 = new Account(3237, "brokerage");
        accountRepository.save(accountB4);
        Account accountB5 = new Account(3238, "brokerage");
        accountRepository.save(accountB5);


        char [] password1 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password2 = {'m', 'y', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password3 = {'1', '2', '3', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password4 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3'};
        char [] password5 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd','a', 'b', 'c'};

        Customer customer1 = new Customer("Michael Knight", " 4 Liberton Park", password1, "michaelknight@gmail.com", "Michael");
        customerRepository.save(customer1);
        Customer customer2 = new Customer("Willie Sanders", " 25 Rose Crescent", password2, "williesanders@gmail.com", "Willie");
        customerRepository.save(customer2);
        Customer customer3 = new Customer("John Smith", " 1 Boulevard", password3, "johnsmith@gmail.com", "John");
        customerRepository.save(customer3);
        Customer customer4 = new Customer("Richard Mouse", " 7 Lasswade", password4, "richarmouse@gmail.com", "Richard");
        customerRepository.save(customer4);
        Customer customer5 = new Customer("David Horse", " 3 Newington Road", password5, "davidhorse@gmail.com", "David");
        customerRepository.save(customer5);


    }
}
