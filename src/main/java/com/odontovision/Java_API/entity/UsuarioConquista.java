package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_CONQUISTA")
public class UsuarioConquista {

    @EmbeddedId
    private UsuarioConquistaId id;

    @MapsId("usuarioId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    @MapsId("conquistaId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONQUISTA_ID", nullable = false)
    private Conquista conquista;

    @Column(name = "DATA_OBTENCAO")
    private LocalDate dataObtencao;

    // Getters & setters

    public UsuarioConquistaId getId() {
        return id;
    }

    public void setId(UsuarioConquistaId id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Conquista getConquista() {
        return conquista;
    }

    public void setConquista(Conquista conquista) {
        this.conquista = conquista;
    }

    public LocalDate getDataObtencao() {
        return dataObtencao;
    }

    public void setDataObtencao(LocalDate dataObtencao) {
        this.dataObtencao = dataObtencao;
    }
}