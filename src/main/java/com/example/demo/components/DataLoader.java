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
        Account accountS2 = new Account(1235, "saving");
        Account accountS3 = new Account(1236, "saving");
        Account accountS4 = new Account(1237, "saving");
        Account accountS5 = new Account(1238, "saving");

        Account accountM1 = new Account(2234, "market");
        Account accountM2 = new Account(2235, "market");
        Account accountM3 = new Account(2236, "market");
        Account accountM4 = new Account(2237, "market");
        Account accountM5 = new Account(2238, "market");

        Account accountB1 = new Account(3234, "brokerage");
        Account accountB2 = new Account(3235, "brokerage");
        Account accountB3 = new Account(3236, "brokerage");
        Account accountB4 = new Account(3237, "brokerage");
        Account accountB5 = new Account(3238, "brokerage");

        char [] password1 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password2 = {'m', 'y', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password3 = {'1', '2', '3', 'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
        char [] password4 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd', '1', '2', '3'};
        char [] password5 = {'p', 'a', 's', 's', 'w', 'o', 'r', 'd','a', 'b', 'c'};

        Customer customer1 = new Customer("Michael Knight", " 4 Liberton Park", password1, "michaelknight@gmail.com", "Michael");
        Customer customer2 = new Customer("Willie Sanders", " 25 Rose Crescent", password2, "williesanders@gmail.com", "Willie");
        Customer customer3 = new Customer("John Smith", " 1 Boulevard", password3, "johnsmith@gmail.com", "John");
        Customer customer4 = new Customer("Richard Mouse", " 7 Lasswade", password4, "richarmouse@gmail.com", "Richard");
        Customer customer5 = new Customer("David Horse", " 3 Newington Road", password5, "davidhorse@gmail.com", "David");


    }
}
