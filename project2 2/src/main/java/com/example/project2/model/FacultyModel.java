package com.example.project2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="faculties")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FacultyModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;

}
