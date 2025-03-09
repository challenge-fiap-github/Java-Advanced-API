package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;

public class PlanoOdontologicoDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nomePlano;

    @Size(max = 255)
    private String descricao;

    @DecimalMin("0.00")
    private Double preco;

    private Date validade;

    public PlanoOdontologicoDTO() {}

    public PlanoOdontologicoDTO(Long id, String nomePlano, String descricao, Double preco, Date validade) {
        this.id = id;
        this.nomePlano = nomePlano;
        this.descricao = descricao;
        this.preco = preco;
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 100) String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(@NotBlank @Size(max = 100) String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public @Size(max = 255) String getDescricao() {
        return descricao;
    }

    public void setDescricao(@Size(max = 255) String descricao) {
        this.descricao = descricao;
    }

    public @DecimalMin("0.00") Double getPreco() {
        return preco;
    }

    public void setPreco(@DecimalMin("0.00") Double preco) {
        this.preco = preco;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }
}
