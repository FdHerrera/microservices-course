package com.fdherrera.repo;

import com.fdherrera.model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {

}
