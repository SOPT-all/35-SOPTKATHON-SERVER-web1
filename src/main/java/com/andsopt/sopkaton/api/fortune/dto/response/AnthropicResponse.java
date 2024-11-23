package com.andsopt.sopkaton.api.fortune.dto.response;

import java.util.List;

public record AnthropicResponse(
        String id,
        List<AnthropicContentResponse> content
) {
}
