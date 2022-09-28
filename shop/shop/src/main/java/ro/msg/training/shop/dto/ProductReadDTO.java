package ro.msg.training.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.training.shop.entity.Product;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductReadDTO implements Serializable {

    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    private String supplier;
    private String imageUrl;
    private int productCategoryId;
    private String categoryName;
    private String categoryDescription;

    public ProductReadDTO(String name, String description, BigDecimal price,
                          double weight, String supplier, String imageUrl,
                          int productCategoryId, String categoryName, String categoryDescription) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.supplier = supplier;
        this.imageUrl = imageUrl;
        this.productCategoryId = productCategoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }


}

