package com.luv2code.springdemo.controller;



import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomers(Model theModel) {

		List<Customer> theCustomers = customerService.getCustomers();

		theModel.addAttribute("customers",theCustomers);

		return "list-customers";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){

		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer){

		customerService.saveCustomer(customer);

		return "redirect:/customer/list";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int id, Model model){
		Customer customer = customerService.getCustomer(id);

		model.addAttribute("customer", customer);

		return "customer-form";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id){

		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	@GetMapping("/search")
	public String searchCustomers(@RequestParam("theSearchName") String searchName, Model model){

		List<Customer> customers = customerService.searchCustomers(searchName);
		model.addAttribute("customers", customers);
		return "list-customers";
	}
	
}


