package ro.msg.training.shop.dto.order;

import lombok.Data;

import java.sql.Date;

@Data
public class OrderWriteDTO {
	
	private int customerId;
	
	private Date createdAt;
	
	private String country;
	
	private String city;
	
	private String county;
	
	private String streetAddress;
	
}
