package ro.msg.training.shop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.training.shop.entity.Customer;
import ro.msg.training.shop.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public Customer getCustomerById(int id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional.isEmpty()) {
			throw new RuntimeException("Customer does not exist");
		}
		return customerOptional.get();
	}
	
	public List<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<>();
		Iterable<Customer> customerIterable = customerRepository.findAll();
		customerIterable.forEach(customers::add);
		return customers;
	}
	
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	
}
