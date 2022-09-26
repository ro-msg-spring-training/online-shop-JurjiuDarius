package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="first_name", nullable = false)
    private  String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="email_address", nullable = false)
    private String emailAddress;
}
