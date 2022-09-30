package ro.msg.training.shop.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "stock")
public class Stock {
	
	@EmbeddedId
	@JsonUnwrapped
	private StockKey id;
	
	@Column(nullable = false)
	private int quantity;
	
	@JoinColumn(name = "location_id")
	@ManyToOne
	@MapsId("locationId")
	private Location location;
	
	@JoinColumn(name = "product_id")
	@ManyToOne
	@MapsId("productId")
	private Product product;
	
}
