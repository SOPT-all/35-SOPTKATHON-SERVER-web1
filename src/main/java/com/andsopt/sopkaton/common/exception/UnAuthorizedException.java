package com.andsopt.sopkaton.common.exception;

import com.andsopt.sopkaton.common.enums.ErrorStatus;

public class UnAuthorizedException extends CustomException{
    public UnAuthorizedException(ErrorStatus errorStatus) {
        super(errorStatus);
    }
}
