package ro.msg.training.shop.Entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name="revenue")
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne
    private Location location;

    @Column(name="revenue_date",nullable = false)
    private LocalDateTime localDate;

    @Column(name="revenue_sum",nullable = false)
    private Long sum;
}
