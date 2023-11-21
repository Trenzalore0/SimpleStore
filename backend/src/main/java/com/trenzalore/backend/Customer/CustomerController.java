package com.trenzalore.backend.Customer;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/customer")
public class CustomerController {

  @Autowired
  private CustomerRepository customerRepository;

  @GetMapping
  public ResponseEntity<List<CustomerModel>> index() {
    return ResponseEntity.ok(customerRepository.findAll());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerModel> getById(@PathVariable String id) {
    Optional<CustomerModel> customer = customerRepository.findById(id);
    if (customer.isPresent()) {
      return ResponseEntity.ok(customer.get());
    }
    return ResponseEntity.notFound().build();
  }

  @PostMapping
  public ResponseEntity<CustomerModel> create(@RequestBody CustomerModel newCustomer, UriComponentsBuilder ucb) {
    if (customerRepository.existsCustomerByEmail(newCustomer.getEmail())) {
      return ResponseEntity.ok(newCustomer);
    }
    CustomerModel customer = customerRepository.save(newCustomer);
    URI customerLocation = ucb.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
    return ResponseEntity.created(customerLocation).build();
  }

  @PutMapping
  public ResponseEntity<CustomerModel> update(@RequestBody CustomerModel obj, UriComponentsBuilder ucb) {
    if (!customerRepository.existsCustomerByEmail(obj.getEmail())) {
      return ResponseEntity.notFound().build();
    }
    CustomerModel customer = customerRepository.save(obj);
    URI customerLocation = ucb.path("/customer/{id}").buildAndExpand(customer.getId()).toUri();
    return ResponseEntity.created(customerLocation).build();
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable String id) {
    Optional<CustomerModel> customer = customerRepository.findById(id);
    if (customer.isPresent()) {
      customerRepository.delete(customer.get());
    }
  }
}
