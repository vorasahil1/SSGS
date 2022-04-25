package com.example.ssgs;

public class Register {
    private Character  Username;
    private Character Password;
    private Number phoeno;
    private Character Email;

    public Register() {
    }

    public Character  getUsername() {
        return Username;
    }

    public void setUsername(Character  username) {
        Username = username;
    }

    public Character getPassword() {
        return Password;
    }

    public void setPassword(Character password) {
        Password = password;
    }

    public Number getPhoeno() {
        return phoeno;
    }

    public void setPhoeno(Number phoeno) {
        this.phoeno = phoeno;
    }

    public Character getEmail() {
        return Email;
    }

    public void setEmail(Character email) {
        Email = email;
    }
}
