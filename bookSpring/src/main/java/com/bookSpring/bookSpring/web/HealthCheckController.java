package com.bookSpring.bookSpring.web;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @GetMapping("/v1")
    public Map<String, String> healthCheck() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "ok");
        return response;
    }
}
