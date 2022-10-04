package ro.msg.training.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ro.msg.training.shop.entity.Customer;

import java.util.List;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private CustomerService customerService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDetialsService called");
		List<Customer> customers = customerService.getCustomers();
		Customer foundCustomer = null;
		for (Customer customer : customers) {
			if (customer.getUsername().equals(username)) {
				foundCustomer = customer;
			}
		}
		if (foundCustomer == null) {
			throw new UsernameNotFoundException("Username could nout be found");
		}
		UserDetails user = User.withUsername(username).password(foundCustomer.getPassword()).disabled(false).authorities("USER").build();
		return user;
	}
	
}
