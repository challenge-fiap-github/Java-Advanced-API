package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.ConsultaProcedimento;
import com.odontovision.Java_API.entity.ConsultaProcedimentoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaProcedimentoRepository
        extends JpaRepository<ConsultaProcedimento, ConsultaProcedimentoId> {
}