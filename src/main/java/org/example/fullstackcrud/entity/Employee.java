package org.example.fullstackcrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Provide first name")
    @NotNull(message = "First name required")
    @NotEmpty(message = "First name should not be empty")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Provide last name")
    @NotNull(message = "Last name required")
    @NotEmpty(message = "Last name should not be empty")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Provide email")
    @NotNull(message = "Email required")
    @NotEmpty(message = "Email should not be empty")
    @Column(name = "email", nullable = false ,unique = true)
    private  String email;
}
