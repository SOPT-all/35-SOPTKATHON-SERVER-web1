package com.andsopt.sopkaton.api.common.exception;

import com.andsopt.sopkaton.api.common.enums.ErrorStatus;

public class UnAuthorizedException extends CustomException{
    public UnAuthorizedException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
