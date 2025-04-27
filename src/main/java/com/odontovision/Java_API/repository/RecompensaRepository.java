package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {
}
