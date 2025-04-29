package com.odontovision.Java_API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlanoProcedimentoId implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "PLANO_ID", nullable = false)
    private Long planoId;

    @NotNull
    @Column(name = "PROCEDIMENTO_ID", nullable = false)
    private Long procedimentoId;

    // Construtor padrão obrigatório
    public PlanoProcedimentoId() {}

    public PlanoProcedimentoId(Long planoId, Long procedimentoId) {
        this.planoId = planoId;
        this.procedimentoId = procedimentoId;
    }

    public Long getPlanoId() {
        return planoId;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
    }

    public Long getProcedimentoId() {
        return procedimentoId;
    }

    public void setProcedimentoId(Long procedimentoId) {
        this.procedimentoId = procedimentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanoProcedimentoId)) return false;
        PlanoProcedimentoId that = (PlanoProcedimentoId) o;
        return Objects.equals(planoId, that.planoId) &&
                Objects.equals(procedimentoId, that.procedimentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planoId, procedimentoId);
    }
}