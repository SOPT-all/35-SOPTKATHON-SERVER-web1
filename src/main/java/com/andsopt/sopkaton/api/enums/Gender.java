package com.andsopt.sopkaton.api.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE("남자"),
    FEMALE("여자");

    private final String gender;
}
