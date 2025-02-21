package xyz.owlie.acme.entities;

import jakarta.persistence.*;
import java.util.Collection;
@Entity
@Table(name = "shops")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column
    String name;

    @Column
    String vatId;

    @OneToMany(mappedBy = "shop")
    private Collection<Order> orders;

    @OneToMany(mappedBy = "shop")
    private Collection<User> users;
}
