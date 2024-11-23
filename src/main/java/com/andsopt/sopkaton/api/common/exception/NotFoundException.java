package com.andsopt.sopkaton.api.common.exception;

import com.andsopt.sopkaton.api.common.enums.ErrorStatus;

public class NotFoundException extends CustomException {
    public NotFoundException(final ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
