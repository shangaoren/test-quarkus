package xyz.owlie.acme.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "shop_id", nullable = false)
    private Shop shop;
}
