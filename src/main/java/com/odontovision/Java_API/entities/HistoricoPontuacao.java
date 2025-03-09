package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "historico_pontuacao")
public class HistoricoPontuacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    private Date dataConsulta;

    private Integer pontosGanhos;

    private Integer pontosTotais;

    public HistoricoPontuacao() {}

    public HistoricoPontuacao(Usuario usuario, Date dataConsulta, Integer pontosGanhos, Integer pontosTotais) {
        this.usuario = usuario;
        this.dataConsulta = dataConsulta;
        this.pontosGanhos = pontosGanhos;
        this.pontosTotais = pontosTotais;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Date getDataConsulta() { return dataConsulta; }

    public void setDataConsulta(Date dataConsulta) { this.dataConsulta = dataConsulta; }

    public Integer getPontosGanhos() { return pontosGanhos; }

    public void setPontosGanhos(Integer pontosGanhos) { this.pontosGanhos = pontosGanhos; }

    public Integer getPontosTotais() { return pontosTotais; }

    public void setPontosTotais(Integer pontosTotais) { this.pontosTotais = pontosTotais; }
}
