package xyz.owlie.acme.entities;

import jakarta.persistence.*;

@Entity
@Table(name= "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique= true, nullable= false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @ManyToOne()
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public User() {}

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
