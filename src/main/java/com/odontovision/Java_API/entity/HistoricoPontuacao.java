package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Registra o histórico de pontuação por ciclo de cada usuário.
 */
@Entity
@Table(name = "HISTORICO_PONTUACAO")
public class HistoricoPontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Usuário dono deste histórico.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    /**
     * Data da consulta que gerou a pontuação.
     */
    @Column(name = "DATA_CONSULTA")
    private LocalDate dataConsulta;

    /**
     * Pontos ganhos neste registro.
     */
    @NotNull
    @Column(name = "PONTOS_GANHOS", nullable = false)
    private Long pontosGanhos;

    /**
     * Total de pontos acumulados até este registro.
     */
    @NotNull
    @Column(name = "PONTOS_TOTAIS", nullable = false)
    private Long pontosTotais;

    // === Construtor padrão (JPA) ===

    protected HistoricoPontuacao() {}

    // === Getters & Setters ===

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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