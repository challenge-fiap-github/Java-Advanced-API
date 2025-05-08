package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.EnderecoClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoClinicaRepository extends JpaRepository<EnderecoClinica, Long> {
}