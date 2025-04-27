package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "HISTORICO_PONTUACAO")
public class HistoricoPontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @Column(name = "DATA_CONSULTA")
    private LocalDate dataConsulta;

    @Column(name = "PONTOS_GANHOS")
    private Long pontosGanhos;

    @Column(name = "PONTOS_TOTAIS")
    private Long pontosTotais;

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

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Long getPontosGanhos() {
        return pontosGanhos;
    }

    public void setPontosGanhos(Long pontosGanhos) {
        this.pontosGanhos = pontosGanhos;
    }

    public Long getPontosTotais() {
        return pontosTotais;
    }

    public void setPontosTotais(Long pontosTotais) {
        this.pontosTotais = pontosTotais;
    }

}