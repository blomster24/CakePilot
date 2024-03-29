package com.pilot.cakepilot.persistence.entity;

import com.pilot.cakepilot.persistence.audit.AuditableEntity;
import com.pilot.cakepilot.persistence.audit.AuditableEntityListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "customers")
@EntityListeners({AuditableEntity.class, AuditableEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
public class CustomerEntity extends AuditableEntity {

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
