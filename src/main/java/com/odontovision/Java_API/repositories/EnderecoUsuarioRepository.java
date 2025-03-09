package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.EnderecoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuario, Long> {
    List<EnderecoUsuario> findByUsuarioId(Long usuarioId);
}