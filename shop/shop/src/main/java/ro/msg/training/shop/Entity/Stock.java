package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Table(name="stock")
public class Stock {
    @ManyToOne
    private Product product;

    @ManyToOne
    private Location location;

    @Column(nullable = false)
    private int quantity;

}
