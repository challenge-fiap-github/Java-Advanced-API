package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "notificacao")
public class Notificacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String titulo;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String conteudo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataEnvio;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Notificacao() {}

    public Notificacao(String titulo, String conteudo, Date dataEnvio, Usuario usuario) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.usuario = usuario;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getConteudo() { return conteudo; }

    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public Date getDataEnvio() { return dataEnvio; }

    public void setDataEnvio(Date dataEnvio) { this.dataEnvio = dataEnvio; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
