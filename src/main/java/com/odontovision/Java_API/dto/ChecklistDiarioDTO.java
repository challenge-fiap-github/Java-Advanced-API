package com.odontovision.Java_API.dto;

import java.util.Date;

public class ChecklistDiarioDTO {

    private Long id;
    private Long usuarioId;
    private Date data;
    private char escovacao;
    private char fioDental;
    private Long consultaValidacaoId;

    public ChecklistDiarioDTO() {}

    public ChecklistDiarioDTO(Long id, Long usuarioId, Date data, char escovacao, char fioDental, Long consultaValidacaoId) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.data = data;
        this.escovacao = escovacao;
        this.fioDental = fioDental;
        this.consultaValidacaoId = consultaValidacaoId;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public char getEscovacao() {
        return escovacao;
    }

    public void setEscovacao(char escovacao) {
        this.escovacao = escovacao;
    }

    public char getFioDental() {
        return fioDental;
    }

    public void setFioDental(char fioDental) {
        this.fioDental = fioDental;
    }

    public Long getConsultaValidacaoId() {
        return consultaValidacaoId;
    }

    public void setConsultaValidacaoId(Long consultaValidacaoId) {
        this.consultaValidacaoId = consultaValidacaoId;
    }
}
