package com.customermanager;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerTO, Integer> {

    List<CustomerTO> findByLastName(String lastName);

    List<CustomerTO> findByLastNameAndFirstName(String lastName, String firstName);
}