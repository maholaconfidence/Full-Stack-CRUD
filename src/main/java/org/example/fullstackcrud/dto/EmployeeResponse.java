package org.example.fullstackcrud.dto;

public record EmployeeResponse(
        Long id,
        String firstname,
        String lastName,
        String email
) {
}
