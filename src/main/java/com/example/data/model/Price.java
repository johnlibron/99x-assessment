package com.example.data.model;

import lombok.Data;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "prices")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "carton", nullable = false)
    private Integer carton;

    @Column(name = "units", nullable = false)
    private Integer units;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Price whitelist = (Price) o;
        return id != null && Objects.equals(id, whitelist.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
