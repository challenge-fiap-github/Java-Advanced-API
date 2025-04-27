package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CONSULTA")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "DATA_HORA", nullable = false)
    private Instant dataHora;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "DENTISTA_ID", nullable = false)
    private Long dentistaId;

    @NotNull
    @Column(name = "STATUS_ID", nullable = false)
    private Long statusId;

    @NotNull
    @Column(name = "TIPO_CONSULTA_ID", nullable = false)
    private Long tipoConsultaId;

    @Size(max = 255)
    @Column(name = "OBSERVACOES")
    private String observacoes;

    @OneToMany(mappedBy = "consulta")
    private Set<ChecklistDiario> checklistDiarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "consulta")
    private Set<ConsultaProcedimento> consultaProcedimentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "consulta")
    private Set<Diagnostico> diagnosticos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "consulta")
    private Set<ValidacaoChecklist> validacaoChecklists = new LinkedHashSet<>();

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(Long dentistaId) {
        this.dentistaId = dentistaId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTipoConsultaId() {
        return tipoConsultaId;
    }

    public void setTipoConsultaId(Long tipoConsultaId) {
        this.tipoConsultaId = tipoConsultaId;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Set<ChecklistDiario> getChecklistDiarios() {
        return checklistDiarios;
    }

    public void setChecklistDiarios(Set<ChecklistDiario> checklistDiarios) {
        this.checklistDiarios = checklistDiarios;
    }

    public Set<ConsultaProcedimento> getConsultaProcedimentos() {
        return consultaProcedimentos;
    }

    public void setConsultaProcedimentos(Set<ConsultaProcedimento> consultaProcedimentos) {
        this.consultaProcedimentos = consultaProcedimentos;
    }

    public Set<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(Set<Diagnostico> diagnosticos) {
        this.diagnosticos = diagnosticos;
    }

    public Set<ValidacaoChecklist> getValidacaoChecklists() {
        return validacaoChecklists;
    }

    public void setValidacaoChecklists(Set<ValidacaoChecklist> validacaoChecklists) {
        this.validacaoChecklists = validacaoChecklists;
    }
}
