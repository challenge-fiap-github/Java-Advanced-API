package com.odontovision.Java_API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsultaProcedimentoId implements Serializable {
    private static final long serialVersionUID = -953310731727000615L;
    @NotNull
    @Column(name = "CONSULTA_ID", nullable = false)
    private Long consultaId;

    @NotNull
    @Column(name = "PROCEDIMENTO_ID", nullable = false)
    private Long procedimentoId;

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
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
        ConsultaProcedimentoId entity = (ConsultaProcedimentoId) o;
        return Objects.equals(this.procedimentoId, entity.procedimentoId) &&
                Objects.equals(this.consultaId, entity.consultaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(procedimentoId, consultaId);
    }

}