// PlanoProcedimento.java
package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PLANO_PROCEDIMENTO")
public class PlanoProcedimento implements Serializable {

    @EmbeddedId
    private PlanoProcedimentoId id;

    /**
     * Relaciona ao plano; vincula à parte “planoId” do EmbeddedId
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("planoId")
    @JoinColumn(name = "PLANO_ID", nullable = false)
    private PlanoOdontologico plano;

    /**
     * Relaciona ao procedimento; vincula à parte “procedimentoId” do EmbeddedId
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("procedimentoId")
    @JoinColumn(name = "PROCEDIMENTO_ID", nullable = false)
    private Procedimento procedimento;

    // ======== Getters & Setters ========

    public PlanoProcedimentoId getId() {
        return id;
    }

    public void setId(PlanoProcedimentoId id) {
        this.id = id;
    }

    public PlanoOdontologico getPlano() {
        return plano;
    }

    public void setPlano(PlanoOdontologico plano) {
        this.plano = plano;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }
}