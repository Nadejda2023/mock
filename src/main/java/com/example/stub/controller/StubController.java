package com.example.stub.controller;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class StubController {

    private static final Random RANDOM = new Random();
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @GetMapping("/status")
    public Map<String, String> getStatus() {
        delay();
        Map<String, String> response = new HashMap<>();
        response.put("login", "Login1");
        response.put("status", "ok");
        return response;
    }

    @PostMapping("/auth")
    public Map<String, String> postAuth(@RequestBody AuthRequest request) {
        delay();
        Map<String, String> response = new HashMap<>();
        response.put("login", request.getLogin());
        response.put("password", request.getPassword());
        response.put("date", LocalDateTime.now().format(FORMATTER));
        return response;
    }

    // DTO – внутренний класс прямо в контроллере
    static class AuthRequest {
        private String login;
        private String password;

        public String getLogin() { return login; }
        public void setLogin(String login) { this.login = login; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    private void delay() {
        try {
            int ms = 1000 + RANDOM.nextInt(1001); 
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
