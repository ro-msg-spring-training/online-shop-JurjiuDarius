package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product_category")
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

}
