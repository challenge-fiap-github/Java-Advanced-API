package com.odontovision.Java_API.dto;

import java.util.Date;

public class ValidacaoChecklistDTO {

    private Long id;
    private Long usuarioId;
    private Long consultaId;
    private Date dataValidacao;
    private char statusValidacao;
    private Integer pontosBonus;

    public ValidacaoChecklistDTO() {}

    public ValidacaoChecklistDTO(Long id, Long usuarioId, Long consultaId, Date dataValidacao, char statusValidacao, Integer pontosBonus) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.consultaId = consultaId;
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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
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
