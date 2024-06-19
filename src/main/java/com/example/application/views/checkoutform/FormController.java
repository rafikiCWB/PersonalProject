package com.example.application.views.checkoutform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("form")
public class FormController {

    @Autowired
    private FormularioRepository formularioRepository;

    @PostMapping()
    public void createForm(String name, String email){
        var formulario = new CreateForm();
        formulario.setName(name);
        formulario.setEmail(email);
        ResponseEntity.status(HttpStatus.CREATED).body(formularioRepository.save(formulario));

    }

}
