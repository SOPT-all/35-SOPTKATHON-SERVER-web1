package com.andsopt.sopkaton.api.common.exception;

import com.andsopt.sopkaton.api.common.dto.APIErrorResponse;
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
