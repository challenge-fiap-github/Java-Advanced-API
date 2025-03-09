package com.odontovision.Java_API.dtos;

import jakarta.validation.constraints.NotNull;
import java.util.Date;

public class ConsultaDTO {

    private Long id;

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long dentistaId;

    @NotNull
    private Long statusId;

    @NotNull
    private Long tipoConsultaId;

    private Date dataHora;

    private String observacoes;

    public ConsultaDTO() {}

    public ConsultaDTO(Long id, Long usuarioId, Long dentistaId, Long statusId, Long tipoConsultaId, Date dataHora, String observacoes) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.dentistaId = dentistaId;
        this.statusId = statusId;
        this.tipoConsultaId = tipoConsultaId;
        this.dataHora = dataHora;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(@NotNull Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public @NotNull Long getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(@NotNull Long dentistaId) {
        this.dentistaId = dentistaId;
    }

    public @NotNull Long getStatusId() {
        return statusId;
    }

    public void setStatusId(@NotNull Long statusId) {
        this.statusId = statusId;
    }

    public @NotNull Long getTipoConsultaId() {
        return tipoConsultaId;
    }

    public void setTipoConsultaId(@NotNull Long tipoConsultaId) {
        this.tipoConsultaId = tipoConsultaId;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
