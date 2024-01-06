package com.pilot.cakepilot.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer", nullable = false)
    private Integer idCustomer;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String lastName;

    @Column(length = 250, nullable = false)
    private String email;

    @Column(length = 250)
    private String address;

    @Column(length = 20, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> order;

}
