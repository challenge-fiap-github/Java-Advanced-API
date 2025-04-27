package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "HISTORICO_TRATAMENTO")
public class HistoricoTratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "PROCEDIMENTO_ID", nullable = false)
    private Long procedimentoId;

    @NotNull
    @Column(name = "DENTISTA_ID", nullable = false)
    private Long dentistaId;

    @NotNull
    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    @Size(max = 255)
    @Column(name = "OBSERVACOES")
    private String observacoes;

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

    public Long getProcedimentoId() {
        return procedimentoId;
    }

    public void setProcedimentoId(Long procedimentoId) {
        this.procedimentoId = procedimentoId;
    }

    public Long getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(Long dentistaId) {
        this.dentistaId = dentistaId;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

}