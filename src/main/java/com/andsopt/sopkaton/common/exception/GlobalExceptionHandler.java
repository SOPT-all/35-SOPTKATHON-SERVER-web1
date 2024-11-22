package com.andsopt.sopkaton.common.exception;

import com.andsopt.sopkaton.common.dto.APIErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({BadRequestException.class, NotFoundException.class, UnAuthorizedException.class})
    public ResponseEntity<APIErrorResponse> handleCustomException(final CustomException customException){
        return APIErrorResponse.of(customException.getHttpStatus(), customException.getMessage());
    }
}
