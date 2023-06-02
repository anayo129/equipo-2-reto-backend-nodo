package com.retoBackendend.equipo2.dto;

public class LoginRequest {
    //AQUI LLEGA EL EMAIL COMO USERNAME
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }
}
