package com.nashtech.duonghai.shoppingonline.entity;

import com.nashtech.duonghai.shoppingonline.other.constant.ERole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
@Getter
@Setter
public class RoleEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole roleName;

    public RoleEntity() {

    }

    public RoleEntity(ERole roleName) {
        this.roleName = roleName;
    }
}