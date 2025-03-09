package com.odontovision.Java_API.dto;

import java.util.Date;

public class UsuarioConquistaDTO {

    private Long usuarioId;
    private Long conquistaId;
    private Date dataObtencao;

    public UsuarioConquistaDTO() {}

    public UsuarioConquistaDTO(Long usuarioId, Long conquistaId, Date dataObtencao) {
        this.usuarioId = usuarioId;
        this.conquistaId = conquistaId;
        this.dataObtencao = dataObtencao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getConquistaId() {
        return conquistaId;
    }

    public void setConquistaId(Long conquistaId) {
        this.conquistaId = conquistaId;
    }

    public Date getDataObtencao() {
        return dataObtencao;
    }

    public void setDataObtencao(Date dataObtencao) {
        this.dataObtencao = dataObtencao;
    }
}
