package com.nashtech.duonghai.shoppingonline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Setter
@Getter
public class ProductEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String productName;

    @Column
    private String description;

    @Column
    private int quantity;

    @Column
    private double pricePerUnit;

    @ManyToMany
    @JoinTable(  name = "product_carts",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id"))
    private List<ShoppingCartEntity> shoppingCarts;

    @ManyToMany
    @JoinTable(  name = "product_orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<OrderEntity> shoppingOrders;
}
