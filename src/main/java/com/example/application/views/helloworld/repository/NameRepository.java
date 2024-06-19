package com.example.application.views.helloworld.repository;

import com.example.application.views.helloworld.modal.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NameRepository extends JpaRepository<LoginUser, Long> {
}
