package ro.msg.training.shop.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_detail")
@Data
@RequiredArgsConstructor
public class OrderDetail {
    @EmbeddedId
    OrderDetailKey id;

    @Column(nullable = false)
    private int quantity;

    @JoinColumn(name = "product_id")
    @ManyToOne
    @MapsId("productId")
    private Product product;

    @JoinColumn(name = "order_id")
    @ManyToOne
    @MapsId("orderId")
    private Order order;

}
