package com.example.application.views.checkoutform;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FormularioRepository extends JpaRepository<CreateForm, UUID> {
}
