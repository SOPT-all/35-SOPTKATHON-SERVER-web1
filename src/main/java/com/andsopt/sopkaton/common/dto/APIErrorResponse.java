package com.andsopt.sopkaton.common.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public record APIErrorResponse(
        int statusCode,
        String message
) {
    public static ResponseEntity<APIErrorResponse> of(final HttpStatus httpStatus, final String message ) {
        return ResponseEntity.status(httpStatus).body(new APIErrorResponse(httpStatus.value(), message));
    }
}