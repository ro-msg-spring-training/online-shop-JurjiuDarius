package ro.msg.training.shop.dto.product;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductWriteDTO {
	
	private int id;
	
	private String name;
	
	private String description;
	
	private int price;
	
	private double weight;
	
	private int supplierId;
	
	private String imageUrl;
	
	private int productCategoryId;
	
}


