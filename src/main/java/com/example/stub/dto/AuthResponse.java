package com.example.stub.dto;

public class AuthResponse {
    private String login;
    private String password;
    private String date;

    public AuthResponse(String login, String password, String date) {
        this.login = login;
        this.password = password;
        this.date = date;
    }

   
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}