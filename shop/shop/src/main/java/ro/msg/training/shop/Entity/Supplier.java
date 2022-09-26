package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="supplier")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String name;
}
