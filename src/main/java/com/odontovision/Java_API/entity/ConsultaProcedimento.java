package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "CONSULTA_PROCEDIMENTO")
public class ConsultaProcedimento implements Serializable {

    @EmbeddedId
    private ConsultaProcedimentoId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("consultaId")
    @JoinColumn(name = "CONSULTA_ID", nullable = false)
    private Consulta consulta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("procedimentoId")
    @JoinColumn(name = "PROCEDIMENTO_ID", nullable = false)
    private Procedimento procedimento;

    // ======== Getters & Setters ========

    public ConsultaProcedimentoId getId() {
        return id;
    }

    public void setId(ConsultaProcedimentoId id) {
        this.id = id;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }
}