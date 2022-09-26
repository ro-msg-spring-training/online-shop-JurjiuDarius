package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="order_detail")
@Data
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Order order;

    @ManyToOne
    private Customer customer;
}
