package com.odontovision.Java_API.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLANO_PROCEDIMENTO")
public class PlanoProcedimento {

    @EmbeddedId
    private PlanoProcedimentoId id;

    public PlanoProcedimentoId getId() {
        return id;
    }

    public void setId(PlanoProcedimentoId id) {
        this.id = id;
    }
}
