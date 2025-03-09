package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.UsuarioConquista;
import com.odontovision.Java_API.entities.UsuarioConquistaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioConquistaRepository extends JpaRepository<UsuarioConquista, UsuarioConquistaId> {

    List<UsuarioConquista> findByUsuarioId(Long usuarioId);

    Optional<UsuarioConquista> findById(UsuarioConquistaId id);
}