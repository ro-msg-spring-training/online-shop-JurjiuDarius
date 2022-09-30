package ro.msg.training.shop.dto.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReadDTO implements Serializable {
	
	private String name;
	
	private String description;
	
	private int price;
	
	private double weight;
	
	private String supplier;
	
	private String imageUrl;
	
	private int productCategoryId;
	
	private String categoryName;
	
	private String categoryDescription;
	
}

