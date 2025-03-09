package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "validacao_checklist")
public class ValidacaoChecklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    @Temporal(TemporalType.DATE)
    private Date dataValidacao;

    private char statusValidacao; // 'S' ou 'N'

    private Integer pontosBonus;

    public ValidacaoChecklist() {}

    public ValidacaoChecklist(Usuario usuario, Consulta consulta, Date dataValidacao, char statusValidacao, Integer pontosBonus) {
        this.usuario = usuario;
        this.consulta = consulta;
        this.dataValidacao = dataValidacao;
        this.statusValidacao = statusValidacao;
        this.pontosBonus = pontosBonus;
    }

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

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Date getDataValidacao() {
        return dataValidacao;
    }

    public void setDataValidacao(Date dataValidacao) {
        this.dataValidacao = dataValidacao;
    }

    public char getStatusValidacao() {
        return statusValidacao;
    }

    public void setStatusValidacao(char statusValidacao) {
        this.statusValidacao = statusValidacao;
    }

    public Integer getPontosBonus() {
        return pontosBonus;
    }

    public void setPontosBonus(Integer pontosBonus) {
        this.pontosBonus = pontosBonus;
    }
}
