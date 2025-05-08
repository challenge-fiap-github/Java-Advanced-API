package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.PlanoProcedimento;
import com.odontovision.Java_API.entity.PlanoProcedimentoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanoProcedimentoRepository
        extends JpaRepository<PlanoProcedimento, PlanoProcedimentoId> {
}