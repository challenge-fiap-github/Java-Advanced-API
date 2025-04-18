package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "PONTUACAO", schema = "RM553568")
public class Pontuacao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PONTUACAO_id_gen")
    @SequenceGenerator(name = "PONTUACAO_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "PONTOS", nullable = false)
    private Long pontos;

    @NotNull
    @Column(name = "DATA_REGISTRO", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "CICLO_INICIAL")
    private LocalDate cicloInicial;

    @Column(name = "CICLO_FINAL")
    private LocalDate cicloFinal;

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

    public Long getPontos() {
        return pontos;
    }

    public void setPontos(Long pontos) {
        this.pontos = pontos;
    }

    public LocalDate getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDate dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public LocalDate getCicloInicial() {
        return cicloInicial;
    }

    public void setCicloInicial(LocalDate cicloInicial) {
        this.cicloInicial = cicloInicial;
    }

    public LocalDate getCicloFinal() {
        return cicloFinal;
    }

    public void setCicloFinal(LocalDate cicloFinal) {
        this.cicloFinal = cicloFinal;
    }

}