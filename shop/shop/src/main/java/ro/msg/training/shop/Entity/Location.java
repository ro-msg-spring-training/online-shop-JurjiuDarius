package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Embedded
    private Address address;
}
