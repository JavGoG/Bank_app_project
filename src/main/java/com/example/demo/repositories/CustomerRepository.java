package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findAllByNameAndByEmailAndByUserNameAndByAddress(String name, String email, String userName, String address);

    List<Customer> findAllByNameAndByEmailAndByUserName(String name, String email, String userName);

    List<Customer> findAllByNameAndByEmail(String name, String email);

    List<Customer> findAllByName(String name);

    List<Customer> findAllByCustomerId(Long id);
}
