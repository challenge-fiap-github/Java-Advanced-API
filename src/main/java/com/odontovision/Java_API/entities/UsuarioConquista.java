package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario_conquista")
public class UsuarioConquista {

    @EmbeddedId
    private UsuarioConquistaId id;

    @ManyToOne
    @MapsId("usuario") // Mapeia a chave primária composta
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @MapsId("conquista") // Mapeia a chave primária composta
    @JoinColumn(name = "conquista_id", nullable = false)
    private Conquista conquista;

    @Temporal(TemporalType.DATE)
    private Date dataObtencao;

    public UsuarioConquista() {}

    public UsuarioConquista(Usuario usuario, Conquista conquista, Date dataObtencao) {
        this.id = new UsuarioConquistaId(usuario.getId(), conquista.getId());
        this.usuario = usuario;
        this.conquista = conquista;
        this.dataObtencao = dataObtencao;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.id.setUsuario(usuario.getId());
    }

    public Conquista getConquista() { return conquista; }
    public void setConquista(Conquista conquista) {
        this.conquista = conquista;
        this.id.setConquista(conquista.getId());
    }

    public Date getDataObtencao() { return dataObtencao; }
    public void setDataObtencao(Date dataObtencao) { this.dataObtencao = dataObtencao; }
}