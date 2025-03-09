package com.odontovision.Java_API.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "plano_procedimento")
public class PlanoProcedimento {

    @Id
    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private PlanoOdontologico planoOdontologico;

    @Id
    @ManyToOne
    @JoinColumn(name = "procedimento_id", nullable = false)
    private Procedimento procedimento;

    public PlanoProcedimento() {}

    public PlanoProcedimento(PlanoOdontologico planoOdontologico, Procedimento procedimento) {
        this.planoOdontologico = planoOdontologico;
        this.procedimento = procedimento;
    }

    public PlanoOdontologico getPlanoOdontologico() { return planoOdontologico; }

    public void setPlanoOdontologico(PlanoOdontologico planoOdontologico) { this.planoOdontologico = planoOdontologico; }

    public Procedimento getProcedimento() { return procedimento; }

    public void setProcedimento(Procedimento procedimento) { this.procedimento = procedimento; }
}
