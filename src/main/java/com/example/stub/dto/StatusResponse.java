package com.example.stub.dto;

public class StatusResponse {
    private String login;
    private String status;

    public StatusResponse(String login, String status) {
        this.login = login;
        this.status = status;
    }

    
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}