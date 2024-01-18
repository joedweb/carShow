// Record a class with getters and toString (?)

package com.binary.carShow.exception;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record ApiError(
        String path,
        String message,
        int statusCode,
        LocalDateTime timestamp) {

}
