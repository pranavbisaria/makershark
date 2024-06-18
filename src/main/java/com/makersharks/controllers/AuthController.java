package com.makersharks.controllers;

import com.makersharks.payloads.register.RegisterUserRequest;
import com.makersharks.payloads.reponse.MessageResponse;
import com.makersharks.payloads.response.UserResponse;
import com.makersharks.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<MessageResponse> registerUser(@Valid RegisterUserRequest registerUserRequest) {
        this.authService.registerUser(registerUserRequest);
        return new ResponseEntity<>(new MessageResponse("User has been successfully created!"), HttpStatus.CREATED);
    }

    @GetMapping("/fetch")
    public ResponseEntity<UserResponse> fetchUsers(@Param("username") String username) {
        return new ResponseEntity<>(this.authService.fetchUser(username), HttpStatus.OK);
    }
}
