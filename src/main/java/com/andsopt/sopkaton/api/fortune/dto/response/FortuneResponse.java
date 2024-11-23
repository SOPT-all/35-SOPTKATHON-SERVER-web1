package com.andsopt.sopkaton.api.fortune.dto.response;

public record FortuneResponse(
        String response
) {

    public static FortuneResponse of(final String response) {
        return new FortuneResponse(response);
    }
}
