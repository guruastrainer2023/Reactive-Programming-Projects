package com.training.ui;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.Customer;
import com.training.exception.CustomerAlreadyExistsException;
import com.training.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerContoller {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/allCustomers")
	public List<Customer>findAll() {
		List<Customer> allCustomers=this.customerService.getAllCustomers();
		return allCustomers;
	}
	
	@GetMapping("/findCustomer/{num}")
	public ResponseEntity<Customer> findById(@PathVariable(name = "num") int id){
		Customer customer=this.customerService.getCustomerById(id);
		return ResponseEntity.ok(customer);
	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> add(@RequestBody Customer customer) throws CustomerAlreadyExistsException{
		Customer c=this.customerService.addCustomer(customer);
		return ResponseEntity.ok(c);
	}
	
	/*@ExceptionHandler(CustomerAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleEmployeeNotFound(	CustomerAlreadyExistsException exception
    ) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }*/

}
