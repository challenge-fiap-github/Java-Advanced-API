package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario_nivel")
public class UsuarioNivel {

    @EmbeddedId
    private UsuarioNivelId id;

    @ManyToOne
    @MapsId("usuario") // Mapeia a chave primária composta
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @MapsId("nivel") // Mapeia a chave primária composta
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;

    @Column(nullable = false)
    private Integer pontosAtuais;

    @Temporal(TemporalType.DATE)
    private Date dataUltimaAtualizacao;

    public UsuarioNivel() {}

    public UsuarioNivel(Usuario usuario, Nivel nivel, Integer pontosAtuais, Date dataUltimaAtualizacao) {
        this.id = new UsuarioNivelId(usuario.getId(), nivel.getId());
        this.usuario = usuario;
        this.nivel = nivel;
        this.pontosAtuais = pontosAtuais;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
        this.id.setUsuario(usuario.getId());
    }

    public Nivel getNivel() { return nivel; }
    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
        this.id.setNivel(nivel.getId());
    }

    public Integer getPontosAtuais() { return pontosAtuais; }
    public void setPontosAtuais(Integer pontosAtuais) { this.pontosAtuais = pontosAtuais; }

    public Date getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) { this.dataUltimaAtualizacao = dataUltimaAtualizacao; }
}