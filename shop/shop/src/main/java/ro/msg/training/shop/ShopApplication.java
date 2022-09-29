package ro.msg.training.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ro.msg.training.shop.repository.CustomerRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class ShopApplication {



	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
		
	}

}
