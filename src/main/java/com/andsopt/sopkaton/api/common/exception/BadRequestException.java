package com.andsopt.sopkaton.api.common.exception;

import com.andsopt.sopkaton.api.common.enums.ErrorStatus;

public class BadRequestException extends CustomException {
    public BadRequestException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
