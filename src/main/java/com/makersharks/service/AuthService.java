package com.makersharks.service;

import com.makersharks.payloads.register.RegisterUserRequest;
import com.makersharks.payloads.response.UserResponse;

public interface AuthService {
    void registerUser(RegisterUserRequest request);

    UserResponse fetchUser(String username);
}
