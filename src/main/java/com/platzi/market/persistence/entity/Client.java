package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Integer clientId;
    private String name;
    private String lastname;
    private String direction;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;


}
