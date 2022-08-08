package com.example.data.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "units_per_carton", nullable = false)
    private Integer unitsPerCarton;

    @Column(name = "carton_price", nullable = false)
    private Integer cartonPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Product whitelist = (Product) o;
        return id != null && Objects.equals(id, whitelist.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
