package ro.msg.training.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ro.msg.training.shop.entity.Customer;
import ro.msg.training.shop.service.CustomerService;

import java.util.List;

@Configuration
@EnableWebSecurity
public class BasicConfiguration {
	
	@Autowired
	private CustomerService customerService;
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService(PasswordEncoder passwordEncoder) {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		List<Customer> customers = customerService.getCustomers();
		for (Customer customer : customers) {
			UserDetails user = User.withUsername(customer.getUsername()).password(passwordEncoder.encode(customer.getPassword())).roles("USER").build();
			inMemoryUserDetailsManager.createUser(user);
		}
		
		return inMemoryUserDetailsManager;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
		return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return encoder;
	}
	
}
