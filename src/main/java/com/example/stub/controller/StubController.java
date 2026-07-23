package com.example.stub.controller;

import com.example.stub.dto.AuthResponse;
import com.example.stub.dto.StatusResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid; 
import com.example.stub.dto.AuthRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

@RestController
@RequestMapping("/api")
public class StubController {

    private static final Random RANDOM = new Random();
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Value("${app.delay.min:1000}")
    private int delayMin;

    @Value("${app.delay.max:2000}")
    private int delayMax;

    @GetMapping("/status")
    public ResponseEntity<StatusResponse> getStatus() {
        delay();
        StatusResponse response = new StatusResponse("Login1", "ok");
        return ResponseEntity.ok(response);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> postAuth(@Valid @RequestBody AuthRequest request) {
        delay();
        String date = LocalDateTime.now().format(FORMATTER);
        AuthResponse response = new AuthResponse(
                request.getLogin(),
                request.getPassword(),
                date
        );
        return ResponseEntity.ok(response);
    }

    private void delay() {
        try {
            int range = delayMax - delayMin;
            int ms = (range > 0) ? delayMin + RANDOM.nextInt(range + 1) : delayMin;
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}