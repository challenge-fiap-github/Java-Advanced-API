package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.UsuarioPlano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioPlanoRepository extends JpaRepository<UsuarioPlano, Long> {
}