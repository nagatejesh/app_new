package com.nbc.app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    @Column(name = "name", length = 250)
    private String name;
    @Column(nullable = false, unique = true)
    private String email;
    private String ofcLocation;
    @Column(nullable = true)
    private String gender;
}
