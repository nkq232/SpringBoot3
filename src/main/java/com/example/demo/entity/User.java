package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@Table(name="user")
public class User {

    @Column(name="id")
    private int id;

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="active")
    private int active;

    @ManyToOne
    @JoinColumn(name="authority_id")
    private Authority authority;

    public User(String username, String password, String firstName, String lastName, String email, int active, Authority authority) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.authority = authority;
    }
}
