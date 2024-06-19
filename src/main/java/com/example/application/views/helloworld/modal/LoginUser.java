package com.example.application.views.helloworld.modal;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_user_login")
public class LoginUser {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String email;
    private String telefone;

    public LoginUser() {
    }

    public LoginUser(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public LoginUser(String name, String email, String telefone) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
