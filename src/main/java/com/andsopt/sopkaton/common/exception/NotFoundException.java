package com.andsopt.sopkaton.common.exception;

import com.andsopt.sopkaton.common.enums.ErrorStatus;

public class NotFoundException extends CustomException {
    public NotFoundException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
