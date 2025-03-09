package com.odontovision.Java_API.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "consulta_procedimento")
public class ConsultaProcedimento {

    @Id
    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    @Id
    @ManyToOne
    @JoinColumn(name = "procedimento_id", nullable = false)
    private Procedimento procedimento;

    public ConsultaProcedimento() {}

    public ConsultaProcedimento(Consulta consulta, Procedimento procedimento) {
        this.consulta = consulta;
        this.procedimento = procedimento;
    }

    public Consulta getConsulta() { return consulta; }

    public void setConsulta(Consulta consulta) { this.consulta = consulta; }

    public Procedimento getProcedimento() { return procedimento; }

    public void setProcedimento(Procedimento procedimento) { this.procedimento = procedimento; }
}
