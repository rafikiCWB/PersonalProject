package com.example.application.views.checkoutform;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormService {

    @Autowired
    private FormularioRepository formularioRepository;

    @Transactional()
    public void move(long listId, int sourceIndex, int destinationIndex) {
        List<CreateForm> list = formularioRepository.findAll();

    }

}
