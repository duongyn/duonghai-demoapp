package com.nashtech.duonghai.shoppingonline.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "shopping_orders")
@Setter
@Getter
public class OrderEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String customerAddress;

    @Column
    private double totalPrice;

    @Column
    private String orderType;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private UserEntity orderOwner;

    @ManyToMany(mappedBy = "shoppingOrders")
    List<ProductEntity> products;


}
