package ro.msg.training.shop.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import ro.msg.training.shop.entity.Location;
import ro.msg.training.shop.entity.Product;

@Data
@AllArgsConstructor
public class ProductLocationDTO {
	
	private Product product;
	
	private Location location;
	
	private Integer quantity;
	
}
