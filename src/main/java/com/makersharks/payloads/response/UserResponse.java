package com.makersharks.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String username;
    private Long birthYear;
    private String address;
    private String about;
    private LocalDateTime joinedOn;
}
