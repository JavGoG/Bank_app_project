package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private char[] password;
    @Column(name = "email")
    private String email;
    @JsonIgnoreProperties({"customer"})
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Account> accounts;

    public Customer() {
    }

    public Customer(String name, String address, char[] password, String email, String userName) {
        this.name = name;
        this.address = address;
        this.accounts = new ArrayList<>();
        this.password = password;
        this.email = email;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setMame(String mame) {
        this.name = mame;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Account> getAccount() {
        return accounts;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public char[] getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
