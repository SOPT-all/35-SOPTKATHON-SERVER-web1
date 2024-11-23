package com.andsopt.sopkaton.api.fortune.dto.request;

import com.andsopt.sopkaton.api.enums.Gender;

public record FortuneRequest(
        String name,
        String birth,
        boolean isLunar,
        String period,
        Gender gender,
        String today,
        String tomorrow,
        String afterTomorrow
) {
}
