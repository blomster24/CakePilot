package com.pilot.cakepilot.persistence.entity;

import com.pilot.cakepilot.persistence.audit.AuditableEntity;
import com.pilot.cakepilot.persistence.audit.AuditableEntityListener;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ingredients")
@EntityListeners({AuditableEntity.class, AuditableEntityListener.class})
@Getter
@Setter
@NoArgsConstructor
public class IngredientEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "id_ingredient")
    private Integer idIngredient;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, name = "supplier")
    private String supplier;

    @Column(length = 5, nullable = false)
    private String unit;

    @Column(nullable = false)
    private Integer quantity;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean deleted;

}
