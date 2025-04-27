package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Sinistro}
 */
public class SinistroResponseDto implements Serializable {
    private final Long id;
    private final Long pacienteId;
    private final Long procedimentoId;
    private final LocalDate dataSinistro;
    private final Boolean riscoFraude;
    @Size(max = 255)
    private final String descricaoRisco;

    public SinistroResponseDto(Long id, Long pacienteId, Long procedimentoId, LocalDate dataSinistro, Boolean riscoFraude, String descricaoRisco) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.procedimentoId = procedimentoId;
        this.dataSinistro = dataSinistro;
        this.riscoFraude = riscoFraude;
        this.descricaoRisco = descricaoRisco;
    }

    public Long getId() {
        return id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public Long getProcedimentoId() {
        return procedimentoId;
    }

    public LocalDate getDataSinistro() {
        return dataSinistro;
    }

    public Boolean getRiscoFraude() {
        return riscoFraude;
    }

    public String getDescricaoRisco() {
        return descricaoRisco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinistroResponseDto entity = (SinistroResponseDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.pacienteId, entity.pacienteId) &&
                Objects.equals(this.procedimentoId, entity.procedimentoId) &&
                Objects.equals(this.dataSinistro, entity.dataSinistro) &&
                Objects.equals(this.riscoFraude, entity.riscoFraude) &&
                Objects.equals(this.descricaoRisco, entity.descricaoRisco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pacienteId, procedimentoId, dataSinistro, riscoFraude, descricaoRisco);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "pacienteId = " + pacienteId + ", " +
                "procedimentoId = " + procedimentoId + ", " +
                "dataSinistro = " + dataSinistro + ", " +
                "riscoFraude = " + riscoFraude + ", " +
                "descricaoRisco = " + descricaoRisco + ")";
    }
}