package com.blorferind.contoller;

import java.awt.PageAttributes.MediaType;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.blorferind.entities.Customer;
import com.blorferind.repository.CustomerRepository;

@Transactional
@RestController
@RequestMapping(value = "/rest/customer")
public class CustomerController {
  
  @Autowired
  CustomerRepository customerRepository;
  @GetMapping(value = "/all")
  public List<Customer> getAll() {
    return customerRepository.findAll();
  }
  @PutMapping("/updateCustomer/{id}")
  public ResponseEntity<Object> updateCustomerById(@RequestBody Customer customer,
      @PathVariable Integer id) {
    Optional<Customer> studentOptional = customerRepository.findById(id);
    if (!studentOptional.isPresent())
      return ResponseEntity.notFound().build();
    customer.setId(id);
    customerRepository.save(customer);
    return ResponseEntity.noContent().build();
  }
  @PostMapping(value = "/load")
  public List<Customer> persist(@RequestBody final Customer customer) {
    customerRepository.save(customer);
    return customerRepository.findAll();
  }
  @PostMapping(value = "/createNewCustomer")
  public ResponseEntity<Customer> createNewCustomer(@RequestBody Customer newCustomer) {
    Customer customer = customerRepository.save(newCustomer);
    return new ResponseEntity<>(customer, HttpStatus.CREATED);
  }s
  @GetMapping("/getCustomerById")
  public Customer getCustomerById(Integer id) {
    return customerRepository.getById(id);
  }
}
