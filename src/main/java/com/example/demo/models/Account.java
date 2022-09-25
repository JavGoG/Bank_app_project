package com.example.demo.models;
import com.example.demo.repositories.AccountRepository;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "accounts")
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number")
    private long number;

    @Column(name = "type")
    private String type;
    @JsonIgnoreProperties({"course"})
    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Account> accounts;

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public long getNumber() {
        return number;
    }

    public String getType() {
        return type;
    }

    public Account(long number, String type) {
        this.number = number;
        this.type = type;
        this.accounts = new ArrayList<>();
    }
    public Account(){}
}
