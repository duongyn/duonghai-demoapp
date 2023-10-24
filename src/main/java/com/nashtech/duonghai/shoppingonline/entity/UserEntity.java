package com.nashtech.duonghai.shoppingonline.entity;

import com.nashtech.duonghai.shoppingonline.other.constant.Provider;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
@Setter
@Getter
public class UserEntity extends BaseEntity {
    @Id
    @GenericGenerator(name = "user_id",
            parameters = @org.hibernate.annotations.Parameter(name = "prefix", value = "SP"),
            strategy = "com.nashtech.duonghai.shoppingonline.other.generator.UserIdGenerator")
    @GeneratedValue(generator = "user_id")
    @Column(name = "user_id")
    private String userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "email")
    private String email;

    @Enumerated(EnumType.STRING)
    @Column
    private Provider provider;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<RoleEntity> roles;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<ShoppingCartEntity> shoppingCarts;

    @OneToMany(mappedBy = "orderOwner", cascade = CascadeType.ALL)
    private List<OrderEntity> shoppingOrders;

    public UserEntity() {
    }

    public UserEntity(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
