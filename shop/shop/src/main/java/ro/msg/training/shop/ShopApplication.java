package ro.msg.training.shop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.msg.training.shop.Repository.CustomerRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class ShopApplication {

	@Autowired
	CustomerRepository customerRepository;


	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		
	}

}
