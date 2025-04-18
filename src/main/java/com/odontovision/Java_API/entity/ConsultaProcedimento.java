package com.odontovision.Java_API.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONSULTA_PROCEDIMENTO", schema = "RM553568")
public class ConsultaProcedimento {
    @SequenceGenerator(name = "CONSULTA_PROCEDIMENTO_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @EmbeddedId
    private ConsultaProcedimentoId id;

    public ConsultaProcedimentoId getId() {
        return id;
    }

    public void setId(ConsultaProcedimentoId id) {
        this.id = id;
    }

    //TODO [Reverse Engineering] generate columns from DB
}