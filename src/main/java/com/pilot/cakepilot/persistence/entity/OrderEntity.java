package com.pilot.cakepilot.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_customer", nullable = false)
    private Integer idCustomer;

    @Column(name = "order_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime orderDate;

    @Column(name = "delivery_date", nullable = false, columnDefinition = "DATETIME")
    private LocalDateTime deliveryDate;

    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "total_amount", nullable = false, columnDefinition = "DECIMAL(10,2)")
    private Double totalAmount;

    @Column(name = "pay_method", nullable = false, columnDefinition = "CHAR(1)")
    private String payMethod;

    @OneToMany(mappedBy = "order")
    private List<OrderProductEntity> orderProducts;

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
    private CustomerEntity customer;

}
