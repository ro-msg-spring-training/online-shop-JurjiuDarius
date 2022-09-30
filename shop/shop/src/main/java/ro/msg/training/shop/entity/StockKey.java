package ro.msg.training.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class StockKey implements Serializable {
	
	@Column(name = "product_id", nullable = false)
	private Integer productId;
	
	@Column(name = "product_id", nullable = false)
	private Integer locationId;
	
}
