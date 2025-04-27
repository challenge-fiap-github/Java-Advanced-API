package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
