package com.springSecuriy.springsecuritysec1.repositoy;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springSecuriy.springsecuritysec1.models.Customer;



@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Optional<Customer> findByEmail(String email);

}
