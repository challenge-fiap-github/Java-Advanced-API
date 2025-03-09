package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.UsuarioNivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioNivelRepository extends JpaRepository<UsuarioNivel, Long> {
    Optional<UsuarioNivel> findByUsuarioId(Long usuarioId);
}