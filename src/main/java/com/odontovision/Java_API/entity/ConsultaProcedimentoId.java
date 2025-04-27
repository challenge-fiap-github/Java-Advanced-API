package com.odontovision.Java_API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ConsultaProcedimentoId implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "CONSULTA_ID", nullable = false)
    private Long consultaId;

    @NotNull
    @Column(name = "PROCEDIMENTO_ID", nullable = false)
    private Long procedimentoId;

    // 🔵 Construtor padrão obrigatório
    public ConsultaProcedimentoId() {
    }

    public ConsultaProcedimentoId(Long consultaId, Long procedimentoId) {
        this.consultaId = consultaId;
        this.procedimentoId = procedimentoId;
    }

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
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaProcedimentoId that = (ConsultaProcedimentoId) o;
        return Objects.equals(consultaId, that.consultaId) &&
                Objects.equals(procedimentoId, that.procedimentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consultaId, procedimentoId);
    }
}
