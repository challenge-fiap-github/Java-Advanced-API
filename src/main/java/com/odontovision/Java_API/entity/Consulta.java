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

    /**
     * Relação com Usuario.
     * Substitui o atributo usuarioId.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    /**
     * Relação com Dentista.
     * Substitui o atributo dentistaId.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DENTISTA_ID", nullable = false)
    private Dentista dentista;

    /**
     * Relação com StatusConsulta.
     * Substitui o atributo statusId.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "STATUS_ID", nullable = false)
    private StatusConsulta statusConsulta;

    /**
     * Relação com TipoConsulta.
     * Substitui o atributo tipoConsultaId.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TIPO_CONSULTA_ID", nullable = false)
    private TipoConsulta tipoConsulta;

    @Size(max = 255)
    @Column(name = "OBSERVACOES")
    private String observacoes;

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ChecklistDiario> checklistDiarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ConsultaProcedimento> consultaProcedimentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Diagnostico> diagnosticos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "consulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ValidacaoChecklist> validacaoChecklists = new LinkedHashSet<>();

    // ======== Getters & Setters ========

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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    public void setStatusConsulta(StatusConsulta statusConsulta) {
        this.statusConsulta = statusConsulta;
    }

    public TipoConsulta getTipoConsulta() {
        return tipoConsulta;
    }

    public void setTipoConsulta(TipoConsulta tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
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