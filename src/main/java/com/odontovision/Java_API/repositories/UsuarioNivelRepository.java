package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.UsuarioNivel;
import com.odontovision.Java_API.entities.UsuarioNivelId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioNivelRepository extends JpaRepository<UsuarioNivel, UsuarioNivelId> {

    List<UsuarioNivel> findByUsuarioId(Long usuarioId);

    Optional<UsuarioNivel> findById(UsuarioNivelId id);
}