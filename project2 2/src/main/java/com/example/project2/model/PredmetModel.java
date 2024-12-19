package com.example.project2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="predmet")
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PredmetModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
}
