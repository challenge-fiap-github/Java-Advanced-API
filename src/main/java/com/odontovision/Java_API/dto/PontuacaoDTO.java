package com.odontovision.Java_API.dto;

import java.util.Date;

public class PontuacaoDTO {

    private Long id;
    private Long usuarioId;
    private Integer pontos;
    private Date dataRegistro;
    private Date cicloInicial;
    private Date cicloFinal;

    public PontuacaoDTO() {}

    public PontuacaoDTO(Long id, Long usuarioId, Integer pontos, Date dataRegistro, Date cicloInicial, Date cicloFinal) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.pontos = pontos;
        this.dataRegistro = dataRegistro;
        this.cicloInicial = cicloInicial;
        this.cicloFinal = cicloFinal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getPontos() {
        return pontos;
    }

    public void setPontos(Integer pontos) {
        this.pontos = pontos;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getCicloInicial() {
        return cicloInicial;
    }

    public void setCicloInicial(Date cicloInicial) {
        this.cicloInicial = cicloInicial;
    }

    public Date getCicloFinal() {
        return cicloFinal;
    }

    public void setCicloFinal(Date cicloFinal) {
        this.cicloFinal = cicloFinal;
    }
}
