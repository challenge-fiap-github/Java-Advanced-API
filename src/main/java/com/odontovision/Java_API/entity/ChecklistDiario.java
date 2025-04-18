package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "CHECKLIST_DIARIO", schema = "RM553568")
public class ChecklistDiario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHECKLIST_DIARIO_id_gen")
    @SequenceGenerator(name = "CHECKLIST_DIARIO_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    @Column(name = "ESCOVACAO")
    private Boolean escovacao;

    @Column(name = "FIO_DENTAL")
    private Boolean fioDental;

    @Column(name = "CONSULTA_VALIDACAO_ID")
    private Long consultaValidacaoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getEscovacao() {
        return escovacao;
    }

    public void setEscovacao(Boolean escovacao) {
        this.escovacao = escovacao;
    }

    public Boolean getFioDental() {
        return fioDental;
    }

    public void setFioDental(Boolean fioDental) {
        this.fioDental = fioDental;
    }

    public Long getConsultaValidacaoId() {
        return consultaValidacaoId;
    }

    public void setConsultaValidacaoId(Long consultaValidacaoId) {
        this.consultaValidacaoId = consultaValidacaoId;
    }

}