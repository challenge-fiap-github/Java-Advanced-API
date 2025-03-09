package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario_conquista")
public class UsuarioConquista {

    @Id
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Id
    @ManyToOne
    @JoinColumn(name = "conquista_id", nullable = false)
    private Conquista conquista;

    @Temporal(TemporalType.DATE)
    private Date dataObtencao;

    public UsuarioConquista() {}

    public UsuarioConquista(Usuario usuario, Conquista conquista, Date dataObtencao) {
        this.usuario = usuario;
        this.conquista = conquista;
        this.dataObtencao = dataObtencao;
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Conquista getConquista() { return conquista; }

    public void setConquista(Conquista conquista) { this.conquista = conquista; }

    public Date getDataObtencao() { return dataObtencao; }

    public void setDataObtencao(Date dataObtencao) { this.dataObtencao = dataObtencao; }
}
