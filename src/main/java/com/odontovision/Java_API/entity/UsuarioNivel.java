package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_NIVEL")
public class UsuarioNivel implements Serializable {

    @EmbeddedId
    private UsuarioNivelId id;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    @MapsId("nivelId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NIVEL_ID", nullable = false)
    private Nivel nivel;

    @Column(name = "PONTOS_ATUAIS", nullable = false)
    private Long pontosAtuais;

    @Column(name = "DATA_ULTIMA_ATUALIZACAO")
    private LocalDate dataUltimaAtualizacao;

    // ====== Getters & Setters ======

    public UsuarioNivelId getId() {
        return id;
    }

    public void setId(UsuarioNivelId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Long getPontosAtuais() {
        return pontosAtuais;
    }

    public void setPontosAtuais(Long pontosAtuais) {
        this.pontosAtuais = pontosAtuais;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}