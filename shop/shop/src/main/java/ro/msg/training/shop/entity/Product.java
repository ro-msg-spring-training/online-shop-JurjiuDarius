package ro.msg.training.shop.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(name = "image_url", nullable = false)
	private String imageUrl;
	
	@Column(nullable = false)
	private int price;
	
	@Column(nullable = false)
	private double weight;
	
	@JoinColumn(name = "supplier_id")
	@ManyToOne
	private Supplier supplier;
	
	@JoinColumn(name = "product_category_id")
	@ManyToOne
	private ProductCategory productCategory;
	
	@OneToMany(mappedBy = "product")
	private List<Stock> stocks;
	
}
