package com.jpa;

/**
 * Created by xjliu on 2016-05-22.
 */

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
}