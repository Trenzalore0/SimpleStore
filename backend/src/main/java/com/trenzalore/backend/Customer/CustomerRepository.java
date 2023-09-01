package com.trenzalore.backend.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerModel, String> {

  public boolean existsCustomerByEmail(String email);
  
}
