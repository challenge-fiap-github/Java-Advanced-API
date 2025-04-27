package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.UsuarioNivel;
import com.odontovision.Java_API.entity.UsuarioNivelId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioNivelRepository extends JpaRepository<UsuarioNivel, UsuarioNivelId> {
}
