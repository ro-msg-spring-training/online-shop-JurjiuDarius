package ro.msg.training.shop.dto.product;

import lombok.Data;
import ro.msg.training.shop.entity.Location;
import ro.msg.training.shop.entity.Product;

@Data
public class ProductLocationDTO {
	
	private Product product;
	
	private Location location;
	
	private Integer quantity;
	
	public ProductLocationDTO(Product product, Location location, Integer quantity) {
		this.product = product;
		this.location = location;
		this.quantity = quantity;
	}
	
}
