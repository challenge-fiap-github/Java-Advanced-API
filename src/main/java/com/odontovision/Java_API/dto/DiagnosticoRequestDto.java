package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Diagnostico}
 */
public class DiagnosticoRequestDto implements Serializable {
    private Long id;
    @NotNull
    private Long consultaId;
    @NotNull
    @Size(max = 255)
    private String descricao;
    @NotNull
    private LocalDate data;

    public DiagnosticoRequestDto() {
    }

    public DiagnosticoRequestDto(Long id, Long consultaId, String descricao, LocalDate data) {
        this.id = id;
        this.consultaId = consultaId;
        this.descricao = descricao;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiagnosticoRequestDto entity = (DiagnosticoRequestDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.consultaId, entity.consultaId) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.data, entity.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, consultaId, descricao, data);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "consultaId = " + consultaId + ", " +
                "descricao = " + descricao + ", " +
                "data = " + data + ")";
    }
}