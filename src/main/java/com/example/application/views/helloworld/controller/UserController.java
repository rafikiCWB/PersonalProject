package com.example.application.views.helloworld.controller;

import com.example.application.views.helloworld.modal.LoginUser;
import com.example.application.views.helloworld.repository.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Service
@RestController
@RequestMapping("/hello")
public class UserController {

    @Autowired
    private final NameRepository nameRepository;

    public UserController(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    /*public void saveName(String name) {
        var loginUser = new LoginUser();
        loginUser.setName(name);
        nameRepository.save(loginUser);
    }*/

    @PostMapping("/post")
    public ResponseEntity<LoginUser> saveName(String name, String email, String telefone) {
        var loginUser = new LoginUser();
        loginUser.setName(name);
        loginUser.setEmail(email);
        loginUser.setTelefone(telefone);
        return ResponseEntity.status(HttpStatus.CREATED).body(nameRepository.save(loginUser));
    }

    @DeleteMapping
    public void deleteUser(LoginUser user) {
        nameRepository.delete(user);
    }


}
