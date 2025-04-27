package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.Instant;

@Entity
@Table(name = "NOTIFICACAO")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "TITULO", nullable = false, length = 100)
    private String titulo;

    @Size(max = 255)
    @NotNull
    @Column(name = "CONTEUDO", nullable = false)
    private String conteudo;

    @NotNull
    @Column(name = "DATA_ENVIO", nullable = false)
    private Instant dataEnvio;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Instant getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Instant dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}