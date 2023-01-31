package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/bank")
public class CustomerController {
@Autowired
private CustomerRepository customerRepository;

@PostMapping("/customers")
public Customer createCustomer(@RequestBody Customer customer)
{
	return customerRepository.save(customer);
}


@PutMapping("/customers/{id}")
public ResponseEntity<Customer> updateCustomerByID(@PathVariable(value="id") Long cid, @RequestBody Customer customerDetails)
{
	Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + cid));
	customer.setCname(customerDetails.getCname());
	customer.setCbalance(customerDetails.getCbalance());
	customer.setBid(customerDetails.getBid());
	Customer updateCustomer=customerRepository.save(customer);
	return ResponseEntity.ok().body(updateCustomer);
} 

@DeleteMapping("/customers/{id}")
public ResponseEntity<Customer> deleteCustomerById(@PathVariable(value = "id") Long cid)
  {
	Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + cid));
	customerRepository.delete(customer);
    return ResponseEntity.ok().body(customer);
}

@GetMapping("/customers/{id}")
public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") Long cid)
  {
	Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + cid));
    return ResponseEntity.ok().body(customer);
}

@GetMapping("/customers")
public List<Customer> getAllCustomers()
{
	return customerRepository.findAll();
}



}
