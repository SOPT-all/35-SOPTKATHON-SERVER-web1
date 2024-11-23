package com.andsopt.sopkaton.api.fortune.dto.response;

import lombok.Builder;

@Builder
public record FortuneResponse(
        Long fortuneId,
        String name,
        String todayDate,
        String lastDate,
        String cardName,
        String mainCardImageUrl,
        String subCardImageUrl,
        String cardContent,
        String moneyContent,
        String cautionContent,
        String notableContent,
        String totalContent

) {
}
