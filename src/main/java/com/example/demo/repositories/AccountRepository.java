package com.example.demo.repositories;

import com.example.demo.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    public List<Account> findAccountsByType(String type);
    public List<Account> findAllByCustomerId(Long customerId);
}
