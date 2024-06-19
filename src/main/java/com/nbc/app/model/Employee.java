package com.nbc.app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[A-ZÀ-ÿa-z ]+$", message = "Name shouldn't contain any special characters")
    private String name;
    @Column(nullable = false, unique = true)
    @NotBlank(message = "Email shouldn't be blank")
    @Email(message = "The given email address is invalid")
    private String email;
    private String ofcLocation;
    @Column(nullable = true)
    private String gender;
}
