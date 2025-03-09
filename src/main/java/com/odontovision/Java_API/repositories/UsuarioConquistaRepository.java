package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.UsuarioConquista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UsuarioConquistaRepository extends JpaRepository<UsuarioConquista, Long> {
    List<UsuarioConquista> findByUsuarioId(Long usuarioId);
}