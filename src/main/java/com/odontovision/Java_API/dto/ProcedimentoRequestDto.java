package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProcedimentoRequestDto implements Serializable {

    @NotNull
    @Size(max = 100)
    private final String nomeProcedimento;

    @Size(max = 255)
    private final String descricao;

    @NotNull
    private final BigDecimal custo;

    public ProcedimentoRequestDto(String nomeProcedimento,
                                  String descricao,
                                  BigDecimal custo) {
        this.nomeProcedimento = nomeProcedimento;
        this.descricao = descricao;
        this.custo = custo;
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
}