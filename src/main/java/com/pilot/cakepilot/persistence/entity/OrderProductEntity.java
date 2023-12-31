package com.pilot.cakepilot.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_products")
@Getter
@Setter
@NoArgsConstructor
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "id_order", nullable = false)
    private Integer idOrder;

    @Column(name = "id_product", nullable = false)
    private Integer idProduct;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "id_product", referencedColumnName = "id_product", insertable = false, updatable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
    private OrderEntity order;

}
