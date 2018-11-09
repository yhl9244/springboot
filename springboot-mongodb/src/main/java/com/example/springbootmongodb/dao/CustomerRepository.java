package com.example.springbootmongodb.dao;

import com.example.springbootmongodb.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by suneee on 2018/6/12.
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {

    public Customer findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);
}
