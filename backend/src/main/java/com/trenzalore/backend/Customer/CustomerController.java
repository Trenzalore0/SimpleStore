package com.trenzalore.backend.Customer;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.trenzalore.backend.ControllerAbstract;

@RestController
@RequestMapping("/customer")
public class CustomerController extends ControllerAbstract<CustomerModel, CustomerRepository> {

  @Override
  @PostMapping
  public ResponseEntity<CustomerModel> create(@RequestBody CustomerModel newCustomer, UriComponentsBuilder ucb) {
    if (repository.existsCustomerByEmail(newCustomer.getEmail())) {
      return ResponseEntity.ok(newCustomer);
    }
    CustomerModel customer = repository.save(newCustomer);
    URI customerLocation = ucb.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
    return ResponseEntity.created(customerLocation).build();
  }

  @Override
  @PutMapping
  public ResponseEntity<CustomerModel> update(@RequestBody CustomerModel obj, UriComponentsBuilder ucb) {
    if (!repository.existsCustomerByEmail(obj.getEmail())) {
      return ResponseEntity.notFound().build();
    }
    CustomerModel customer = repository.save(obj);
    URI customerLocation = ucb.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
    return ResponseEntity.created(customerLocation).build();
  }

}
