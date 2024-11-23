package com.andsopt.sopkaton.api.fortune.service;

import com.andsopt.sopkaton.api.fortune.dto.response.AnthropicResponse;
import com.andsopt.sopkaton.api.fortune.dto.response.FortuneResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
public class FortuneService {

    @Value("${anthropic.api.key}")
    private String key;

    @Value("${anthropic.api.url}")
    private String url;

    @Value("${anthropic.api.model}")
    private String model;

    public FortuneResponse createFortune(final String role, final String content) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", key);
        headers.set("anthropic-version", "2023-06-01");
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
                "model", model,
                "max_tokens", 1024,
                "messages", List.of(
                        Map.of(
                                "role", role,
                                "content", content
                        )
                )
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AnthropicResponse> response = restTemplate.postForEntity(
                url,
                entity,
                AnthropicResponse.class
        );

        return FortuneResponse.of(response.getBody().content().getFirst().text());
    }
}
