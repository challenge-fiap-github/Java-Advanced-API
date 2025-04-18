package com.odontovision.Java_API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlanoProcedimentoId implements Serializable {
    private static final long serialVersionUID = 8405514640727551471L;
    @NotNull
    @Column(name = "PLANO_ID", nullable = false)
    private Long planoId;

    @NotNull
    @Column(name = "PROCEDIMENTO_ID", nullable = false)
    private Long procedimentoId;

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
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PlanoProcedimentoId entity = (PlanoProcedimentoId) o;
        return Objects.equals(this.procedimentoId, entity.procedimentoId) &&
                Objects.equals(this.planoId, entity.planoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procedimentoId, planoId);
    }

}