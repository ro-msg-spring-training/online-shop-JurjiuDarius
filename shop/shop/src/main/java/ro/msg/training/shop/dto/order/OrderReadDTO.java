package ro.msg.training.shop.dto.order;

import lombok.Data;

import java.util.ArrayList;

@Data
public class OrderReadDTO {
	
	private int customerId;
	
	private String country;
	
	private String city;
	
	private String county;
	
	private String streetAddress;
	
	private ArrayList<OrderDetailDTO> orderDetails;
	
}
