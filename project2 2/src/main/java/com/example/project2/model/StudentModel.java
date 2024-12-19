package com.example.project2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.List;

@Entity
@Table(name="students")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {
    @Id
    @GeneratedValue
    private  Long id;

    @NotEmpty(message = "Пожалуйста, введите имя")
    private String name;
    @Column(unique = true)
    private String email;
    private  String password;

    @OneToOne(cascade = CascadeType.ALL)
    private PersonaDataModel personaDataModel;

    @ManyToOne(cascade = CascadeType.ALL)
    private FacultyModel facultyModel;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<PredmetModel> predmetModel;
}
