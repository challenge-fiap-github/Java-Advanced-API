package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "pontuacao")
public class Pontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @NotNull
    @Column(nullable = false)
    private Integer pontos;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataRegistro;

    @Temporal(TemporalType.DATE)
    private Date cicloInicial;

    @Temporal(TemporalType.DATE)
    private Date cicloFinal;

    public Pontuacao() {}

    public Pontuacao(Usuario usuario, Integer pontos, Date dataRegistro, Date cicloInicial, Date cicloFinal) {
        this.usuario = usuario;
        this.pontos = pontos;
        this.dataRegistro = dataRegistro;
        this.cicloInicial = cicloInicial;
        this.cicloFinal = cicloFinal;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Integer getPontos() { return pontos; }

    public void setPontos(Integer pontos) { this.pontos = pontos; }

    public Date getDataRegistro() { return dataRegistro; }

    public void setDataRegistro(Date dataRegistro) { this.dataRegistro = dataRegistro; }

    public Date getCicloInicial() { return cicloInicial; }

    public void setCicloInicial(Date cicloInicial) { this.cicloInicial = cicloInicial; }

    public Date getCicloFinal() { return cicloFinal; }

    public void setCicloFinal(Date cicloFinal) { this.cicloFinal = cicloFinal; }
}
