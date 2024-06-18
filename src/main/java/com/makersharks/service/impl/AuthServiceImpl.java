package com.makersharks.service.impl;

import com.makersharks.exceptions.user.EmailAlreadyExistException;
import com.makersharks.exceptions.user.UserNotFoundException;
import com.makersharks.exceptions.user.UsernameAlreadyExistException;
import com.makersharks.payloads.register.RegisterUserRequest;
import com.makersharks.payloads.response.UserResponse;
import com.makersharks.repository.UserRepo;
import com.makersharks.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepo userRepo;

    @Override
    public void registerUser(RegisterUserRequest request) {
        if (this.userRepo.existsByUsername(request.getUsername())) throw new UsernameAlreadyExistException();
        if (this.userRepo.existsByEmail(request.getEmail())) throw new EmailAlreadyExistException();

        this.userRepo.save(request.mapToUserModel());
    }

    @Override
    public UserResponse fetchUser(String username) {
        return this.userRepo.findById(username).orElseThrow(UserNotFoundException::new).mapToUserDto();
    }
}
