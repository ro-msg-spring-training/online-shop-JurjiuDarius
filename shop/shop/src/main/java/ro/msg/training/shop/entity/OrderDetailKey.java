package ro.msg.training.shop.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class OrderDetailKey implements Serializable {
	
	@Column(name = "order_id", nullable = false)
	private Integer orderId;
	
	@Column(name = "product_id", nullable = false)
	private Integer productId;
	
}
