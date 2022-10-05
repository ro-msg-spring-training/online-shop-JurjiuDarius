package ro.msg.training.shop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import ro.msg.training.shop.entity.Customer;
import ro.msg.training.shop.service.CustomerService;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@Profile("basic")
public class BasicSecurityConfiguration {
	
	@Autowired
	private CustomerService customerService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authz) -> authz.anyRequest().authenticated()).httpBasic(withDefaults());
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		InMemoryUserDetailsManager detailsManager = new InMemoryUserDetailsManager();
		for (Customer customer : customerService.getCustomers()) {
			UserDetails user = User.withDefaultPasswordEncoder().username(customer.getUsername()).password(customer.getPassword()).roles("USER").build();
			detailsManager.createUser(user);
		}
		return detailsManager;
	}
	
}
