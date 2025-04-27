package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.UsuarioConquista;
import com.odontovision.Java_API.entity.UsuarioConquistaId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioConquistaRepository extends JpaRepository<UsuarioConquista, UsuarioConquistaId> {
}
