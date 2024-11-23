package com.andsopt.sopkaton.api.common.exception;

import com.andsopt.sopkaton.api.common.enums.ErrorStatus;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;

    public CustomException(final ErrorStatus errorStatus){
        super(errorStatus.getMessage());
        this.httpStatus = errorStatus.getStatus();
        this.message = errorStatus.getMessage();
    }
}
