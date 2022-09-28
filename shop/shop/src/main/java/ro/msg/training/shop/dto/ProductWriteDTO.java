package ro.msg.training.shop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.training.shop.entity.Product;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;
import ro.msg.training.shop.entity.Product;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductWriteDTO implements Serializable {


    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private double weight;
    private int supplierId;
    private String imageUrl;
    private int productCategoryId;


    public ProductWriteDTO(String name, String description, BigDecimal price,
                           double weight, int supplierId, String imageUrl,
                           int productCategoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.supplierId = supplierId;
        this.imageUrl = imageUrl;
        this.productCategoryId = productCategoryId;

    }


}


