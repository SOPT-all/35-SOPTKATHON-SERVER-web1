package com.andsopt.sopkaton.common.exception;

import com.andsopt.sopkaton.common.enums.ErrorStatus;

public class BadRequestException extends CustomException {
    public BadRequestException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
