package com.odontovision.Java_API.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "PLANO_PROCEDIMENTO", schema = "RM553568")
public class PlanoProcedimento {
    @SequenceGenerator(name = "PLANO_PROCEDIMENTO_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @EmbeddedId
    private PlanoProcedimentoId id;

    public PlanoProcedimentoId getId() {
        return id;
    }

    public void setId(PlanoProcedimentoId id) {
        this.id = id;
    }

    //TODO [Reverse Engineering] generate columns from DB
}