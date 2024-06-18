package com.makersharks.payloads.reponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    private Date timestamp;
    private String message;

    public MessageResponse(String message) {
        this.timestamp = new Date();
        this.message = message;
    }
}
