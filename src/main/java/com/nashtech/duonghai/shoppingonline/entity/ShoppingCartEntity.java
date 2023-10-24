package com.nashtech.duonghai.shoppingonline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shopping_carts")
@Setter
@Getter
public class ShoppingCartEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cartType;

    @Column
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserEntity customer;

    @ManyToMany(mappedBy = "shoppingCarts")
    List<ProductEntity> products;
}
