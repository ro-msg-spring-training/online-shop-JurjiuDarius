package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name="orderr")
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Customer customer;

    @Embedded
    private Address address;

    @Column(name="created_at")
    private LocalDateTime createdAt;


}
