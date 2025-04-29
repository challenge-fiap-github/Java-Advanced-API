package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "PONTUACAO")
public class Pontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Antes havia apenas usuarioId.
     * Agora mapeamos para a entidade Usuario.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

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

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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