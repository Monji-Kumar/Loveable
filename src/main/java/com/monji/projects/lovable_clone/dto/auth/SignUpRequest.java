package com.monji.projects.lovable_clone.dto.auth;

import jakarta.validation.constraints.*;

public record SignUpRequest(

        @NotBlank(message = "Name cannot be blank")
        @Size(min = 1, max = 30, message = "Name must be less than 30 characters")
        String name,

        @NotBlank(message = "Username cannot be blank")
        @Email(message = "Invalid email Id")
        String username,

        @NotBlank(message = "Password cannot be blank")
        @Pattern( regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9\\s])\\S{8,}$",
                message = "Password must have at least 8 characters, one lowercase, one uppercase, and one special character, with no spaces"
        )
        String password
) {
}
