package com.odontovision.Java_API.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CONSULTA_PROCEDIMENTO")
public class ConsultaProcedimento {

    @EmbeddedId
    private ConsultaProcedimentoId id;

    public ConsultaProcedimentoId getId() {
        return id;
    }

    public void setId(ConsultaProcedimentoId id) {
        this.id = id;
    }
}
