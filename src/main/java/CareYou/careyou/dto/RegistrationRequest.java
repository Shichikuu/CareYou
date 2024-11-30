package CareYou.careyou.dto;

import jakarta.validation.constraints.*;

public class RegistrationRequest {

    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 3, max = 25, message = "Length of first name must be between 3 - 25 characters")
    private String firstName;

    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 3, max = 25, message = "Length of last name must be between 3 - 25 characters")
    private String lastName;

    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "Email format is invalid")
    private String email;

    @NotEmpty(message = "Password cannot be empty")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotEmpty(message = "Confirm password cannot be empty")
    private String confirmPassword;

    // Getters and setters...

    // Custom validation method for matching passwords
    public boolean isPasswordMatching() {
        return password.equals(confirmPassword);
    }
}