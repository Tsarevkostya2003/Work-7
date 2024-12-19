package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotBlank;


@Table(name = "personal_data")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDataModel {

    @Id
    @GeneratedValue
    private int id;

    @Column(length = 4)
    @NotEmpty(message = "Пожалуйста, введите номер серии")
    private String passportSeria;



    @Column(unique = true)
    @NotEmpty(message = "Пожалуйста, введите номер паспорта")
    @Size(min = 10, message = "Номер паспорта должен быть не менее 10")
    private String passportNumber;

    @Column(length = 16)
    private String kod;
}
