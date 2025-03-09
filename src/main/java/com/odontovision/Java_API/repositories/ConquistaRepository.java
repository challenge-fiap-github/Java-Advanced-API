package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.Conquista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConquistaRepository extends JpaRepository<Conquista, Long> {
}