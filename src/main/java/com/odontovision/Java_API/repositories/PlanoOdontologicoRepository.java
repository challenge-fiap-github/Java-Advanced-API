package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.PlanoOdontologico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoOdontologicoRepository extends JpaRepository<PlanoOdontologico, Long> {
}