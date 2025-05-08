package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.PlanoCobertura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoCoberturaRepository extends JpaRepository<PlanoCobertura, Long> {
}