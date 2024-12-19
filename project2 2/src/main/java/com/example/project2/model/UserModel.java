package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Поле не заполнено")
    private String name;
    @Column(unique = true)
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    RoleModel role;

    public UserModel(String name, String password) {
        this.name = name;
        this.password = password;

    }

    @Override
    public String toString() {
        super.toString();
        return "${this.name}";
    }
}
