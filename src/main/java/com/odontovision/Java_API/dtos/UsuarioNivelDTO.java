package com.odontovision.Java_API.dtos;

import java.util.Date;

public class UsuarioNivelDTO {

    private Long usuarioId;
    private Long nivelId;
    private Integer pontosAtuais;
    private Date dataUltimaAtualizacao;

    public UsuarioNivelDTO() {}

    public UsuarioNivelDTO(Long usuarioId, Long nivelId, Integer pontosAtuais, Date dataUltimaAtualizacao) {
        this.usuarioId = usuarioId;
        this.nivelId = nivelId;
        this.pontosAtuais = pontosAtuais;
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getNivelId() {
        return nivelId;
    }

    public void setNivelId(Long nivelId) {
        this.nivelId = nivelId;
    }

    public Integer getPontosAtuais() {
        return pontosAtuais;
    }

    public void setPontosAtuais(Integer pontosAtuais) {
        this.pontosAtuais = pontosAtuais;
    }

    public Date getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
