package com.quoccuong.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quoccuong.entities.Customer;
import com.quoccuong.service.CustomerService;
import com.quoccuong.service.ServiceResult;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	@Autowired CustomerService customerservice;
	@GetMapping
	public ResponseEntity<ServiceResult> findAllCustomer()
	{
		
		return new ResponseEntity<ServiceResult>(customerservice.findAll(),HttpStatus.OK);
	
	}
	//@GetMapping("/{id}")
	public ResponseEntity<ServiceResult> findById(@PathVariable int id)
	{
		return new ResponseEntity<ServiceResult>(customerservice.findById(id),HttpStatus.OK);
	}
	@PostMapping()
	public void createCustomer(@RequestBody Customer customer)
	{
		customerservice.create(customer);
	}
	
	@PutMapping()
	public ResponseEntity<ServiceResult> updateCustomer(@RequestBody Customer customer)
	{
		
		return  new ResponseEntity<ServiceResult>(customerservice.update(customer),HttpStatus.OK);
	}
	@DeleteMapping()
	public ResponseEntity<ServiceResult> deleteCustomer(@RequestBody Customer customer)
	{
		return new ResponseEntity<ServiceResult>(customerservice.delete(customer),HttpStatus.OK);
	}
	@GetMapping("/{name}")
	public  ResponseEntity<ServiceResult> findBynameLike(@PathVariable String name)
	{
		return new ResponseEntity<ServiceResult>(customerservice.findBynameLike(name),HttpStatus.OK);
	}
}
