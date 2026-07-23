package com.example.stub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthRequest {

    @NotBlank(message = "Login cannot be empty")
    private String login;

    @NotBlank(message = "Password cannot be empty")
    @Size(min = 3, message = "Password must be at least 3 characters")
    private String password;

   
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}