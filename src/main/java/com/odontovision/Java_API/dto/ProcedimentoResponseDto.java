package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Procedimento}
 */
public class ProcedimentoResponseDto implements Serializable {
    private final Long id;
    @NotNull
    @Size(max = 100)
    private final String nomeProcedimento;
    @Size(max = 255)
    private final String descricao;
    private final BigDecimal custo;

    public ProcedimentoResponseDto(Long id, String nomeProcedimento, String descricao, BigDecimal custo) {
        this.id = id;
        this.nomeProcedimento = nomeProcedimento;
        this.descricao = descricao;
        this.custo = custo;
    }

    public Long getId() {
        return id;
    }

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcedimentoResponseDto entity = (ProcedimentoResponseDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nomeProcedimento, entity.nomeProcedimento) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.custo, entity.custo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeProcedimento, descricao, custo);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nomeProcedimento = " + nomeProcedimento + ", " +
                "descricao = " + descricao + ", " +
                "custo = " + custo + ")";
    }
}