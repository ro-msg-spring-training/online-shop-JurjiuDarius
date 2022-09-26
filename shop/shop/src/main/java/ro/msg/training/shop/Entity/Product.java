package ro.msg.training.shop.Entity;

import jdk.jfr.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name="image_url",nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private double weight;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private ProductCategory productCategory;
}
