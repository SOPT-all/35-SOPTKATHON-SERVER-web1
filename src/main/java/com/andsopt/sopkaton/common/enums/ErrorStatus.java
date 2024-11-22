package com.andsopt.sopkaton.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorStatus {
    NOT_FOUND_USER(HttpStatus.NOT_FOUND, " 아이디에 해당하는 유저를 찾을 수 없습니다"),
    NOT_FOUND_TICKET(HttpStatus.NOT_FOUND, "아이디에 해당하는 티켓을 찾을 수 없습니다");

    private final HttpStatus status;

    private final String message;
}
