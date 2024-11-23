package com.andsopt.sopkaton.api.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus {

    TEST(HttpStatus.NOT_FOUND, "test");

    private final HttpStatus status;

    private final String message;
}
