package ro.msg.training.shop.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@RequiredArgsConstructor
@Table(name = "stock")
public class Stock {
    @EmbeddedId
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
    private Location product;


}
