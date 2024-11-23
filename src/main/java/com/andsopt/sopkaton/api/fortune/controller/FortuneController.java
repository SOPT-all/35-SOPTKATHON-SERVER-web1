package com.andsopt.sopkaton.api.fortune.controller;

import com.andsopt.sopkaton.api.common.dto.APISuccessResponse;
import com.andsopt.sopkaton.api.fortune.dto.request.FortuneRequest;
import com.andsopt.sopkaton.api.fortune.dto.response.FortuneResponse;
import com.andsopt.sopkaton.api.fortune.service.FortuneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fortunes")
@RequiredArgsConstructor
public class FortuneController {

    private final FortuneService fortuneService;

    @PostMapping
    public ResponseEntity<APISuccessResponse<FortuneResponse>> createFortune(
            @RequestBody final FortuneRequest fortuneRequest
    ) {

        return APISuccessResponse.of(HttpStatus.OK, fortuneService.createFortune(fortuneRequest.role(), fortuneRequest.content()));
    }
}
