package com.odontovision.Java_API.dto;

import java.util.Date;

public class HistoricoTratamentoDTO {

    private Long id;
    private Long usuarioId;
    private Long procedimentoId;
    private Long dentistaId;
    private Date data;
    private String observacoes;

    public HistoricoTratamentoDTO() {}

    public HistoricoTratamentoDTO(Long id, Long usuarioId, Long procedimentoId, Long dentistaId, Date data, String observacoes) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.procedimentoId = procedimentoId;
        this.dentistaId = dentistaId;
        this.data = data;
        this.observacoes = observacoes;
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

    public Long getProcedimentoId() {
        return procedimentoId;
    }

    public void setProcedimentoId(Long procedimentoId) {
        this.procedimentoId = procedimentoId;
    }

    public Long getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(Long dentistaId) {
        this.dentistaId = dentistaId;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
