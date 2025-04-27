package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.UsuarioPlano}
 */
public class UsuarioPlanoDto implements Serializable {
    private Long id;
    @NotNull
    private Long usuarioId;
    @NotNull
    private Long planoId;
    private LocalDate dataAdesao;

    public UsuarioPlanoDto() {
    }

    public UsuarioPlanoDto(Long id, Long usuarioId, Long planoId, LocalDate dataAdesao) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.planoId = planoId;
        this.dataAdesao = dataAdesao;
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

    public Long getPlanoId() {
        return planoId;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
    }

    public LocalDate getDataAdesao() {
        return dataAdesao;
    }

    public void setDataAdesao(LocalDate dataAdesao) {
        this.dataAdesao = dataAdesao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioPlanoDto entity = (UsuarioPlanoDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.usuarioId, entity.usuarioId) &&
                Objects.equals(this.planoId, entity.planoId) &&
                Objects.equals(this.dataAdesao, entity.dataAdesao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuarioId, planoId, dataAdesao);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "usuarioId = " + usuarioId + ", " +
                "planoId = " + planoId + ", " +
                "dataAdesao = " + dataAdesao + ")";
    }
}