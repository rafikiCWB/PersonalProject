package com.example.application.views.checkoutform;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tb_formulario")
public class CreateForm {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idFormulario;
    private String name;
    private String email;

    public CreateForm(){

    }

    public CreateForm(UUID idFormulario, String name, String email) {
        this.idFormulario = idFormulario;
        this.name = name;
        this.email = email;
    }

    public UUID getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(UUID idFormulario) {
        this.idFormulario = idFormulario;
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
}
