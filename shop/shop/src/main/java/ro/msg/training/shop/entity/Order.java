package ro.msg.training.shop.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table(name = "orderr")
@Data
@Entity
@RequiredArgsConstructor
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne
	private Customer customer;
	
	@JoinColumn(name = "location_id")
	@ManyToOne
	private Location location;
	
	@Embedded
	private Address address;
	
	@OneToMany(mappedBy = "order")
	private List<OrderDetail> orderDetails;
	
	@Column(name = "created_at")
	private java.sql.Date createdAt;
	
}
