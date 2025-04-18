package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Consulta}
 */
public class ConsultaRequestDto implements Serializable {
    @NotNull
    private Instant dataHora;
    @NotNull
    private Long usuarioId;
    @NotNull
    private Long dentistaId;
    @NotNull
    private Long statusId;
    @NotNull
    private Long tipoConsultaId;
    @Size(max = 255)
    private String observacoes;

    public ConsultaRequestDto() {
    }

    public ConsultaRequestDto(Instant dataHora, Long usuarioId, Long dentistaId, Long statusId, Long tipoConsultaId, String observacoes) {
        this.dataHora = dataHora;
        this.usuarioId = usuarioId;
        this.dentistaId = dentistaId;
        this.statusId = statusId;
        this.tipoConsultaId = tipoConsultaId;
        this.observacoes = observacoes;
    }

    public Instant getDataHora() {
        return dataHora;
    }

    public void setDataHora(Instant dataHora) {
        this.dataHora = dataHora;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getDentistaId() {
        return dentistaId;
    }

    public void setDentistaId(Long dentistaId) {
        this.dentistaId = dentistaId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public Long getTipoConsultaId() {
        return tipoConsultaId;
    }

    public void setTipoConsultaId(Long tipoConsultaId) {
        this.tipoConsultaId = tipoConsultaId;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsultaRequestDto entity = (ConsultaRequestDto) o;
        return Objects.equals(this.dataHora, entity.dataHora) &&
                Objects.equals(this.usuarioId, entity.usuarioId) &&
                Objects.equals(this.dentistaId, entity.dentistaId) &&
                Objects.equals(this.statusId, entity.statusId) &&
                Objects.equals(this.tipoConsultaId, entity.tipoConsultaId) &&
                Objects.equals(this.observacoes, entity.observacoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataHora, usuarioId, dentistaId, statusId, tipoConsultaId, observacoes);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "dataHora = " + dataHora + ", " +
                "usuarioId = " + usuarioId + ", " +
                "dentistaId = " + dentistaId + ", " +
                "statusId = " + statusId + ", " +
                "tipoConsultaId = " + tipoConsultaId + ", " +
                "observacoes = " + observacoes + ")";
    }
}