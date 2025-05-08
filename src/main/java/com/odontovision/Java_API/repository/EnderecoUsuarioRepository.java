package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.EnderecoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoUsuarioRepository extends JpaRepository<EnderecoUsuario, Long> {
}