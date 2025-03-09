package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.EnderecoClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EnderecoClinicaRepository extends JpaRepository<EnderecoClinica, Long> {
    List<EnderecoClinica> findByDentistaId(Long dentistaId);
}