package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProcedimentoDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nomeProcedimento;

    @Size(max = 255)
    private String descricao;

    @DecimalMin("0.00")
    private Double custo;

    public ProcedimentoDTO() {}

    public ProcedimentoDTO(Long id, String nomeProcedimento, String descricao, Double custo) {
        this.id = id;
        this.nomeProcedimento = nomeProcedimento;
        this.descricao = descricao;
        this.custo = custo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 100) String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(@NotBlank @Size(max = 100) String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    public @Size(max = 255) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(max = 255) String descricao) {
        this.descricao = descricao;
    }

    public @DecimalMin("0.00") Double getCusto() {
        return custo;
    }

    public void setCusto(@DecimalMin("0.00") Double custo) {
        this.custo = custo;
    }
}
