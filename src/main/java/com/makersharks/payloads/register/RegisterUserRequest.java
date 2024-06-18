package com.makersharks.payloads.register;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.makersharks.exceptions.ApiException;
import com.makersharks.models.User;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserRequest {
    @NotBlank(message = "Username cannot be empty")
    @Size(min = 4, max = 20, message = "Username must be between 4 and 20 characters")
    private String username;

    @Email(message = "Invalid email format")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    @Size(min=8, message = "Password must be minimum of 8 characters")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must Contain at least one uppercase letter, one lowercase letter, one numeric character, one special character and no spaces")
    private String password;

    @Min(value = 1900, message = "Birth year cannot be before 1900")
    private Long birthYear;

    @NotBlank(message = "Address cannot be empty")
    private String address;

    private String about;

    @JsonIgnore
    public boolean isValidBirthYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return birthYear <= currentYear && birthYear > 1900;
    }


    public User mapToUserModel() {
        if (!isValidBirthYear()) {
            throw new ApiException("Birth year should be before current year and after 1900");
        }
        return new User(this.username, this.getEmail(), this.password, this.birthYear, this.address, this.about);
    }
}
