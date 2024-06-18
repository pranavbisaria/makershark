package com.makersharks.models;

import com.makersharks.payloads.response.UserResponse;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter @Setter
public class User {
    @Id
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    private Long birthYear;
    private String address;
    private String about;
    @CreationTimestamp
    private LocalDateTime createdOn;
    @UpdateTimestamp
    private LocalDateTime updatedOn;

    protected static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User(String username, String email, String password, Long birthYear, String address, String about) {
        this.username = username;
        this.email = email;
        this.password = passwordEncoder.encode(password);
        this.birthYear = birthYear;
        this.address = address;
        this.about = about;
    }

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }

    public UserResponse mapToUserDto() {
        return new UserResponse(
                this.username,
                this.birthYear,
                this.address,
                this.about,
                this.createdOn
        );
    }
}