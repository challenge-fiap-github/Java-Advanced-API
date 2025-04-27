package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.PlanoOdontologico}
 */
public class PlanoOdontologicoRequestDto implements Serializable {
    private Long id;
    @NotNull
    @Size(max = 100)
    private String nomePlano;
    @Size(max = 255)
    private String descricao;
    private BigDecimal preco;
    private LocalDate validade;

    public PlanoOdontologicoRequestDto() {
    }

    public PlanoOdontologicoRequestDto(Long id, String nomePlano, String descricao, BigDecimal preco, LocalDate validade) {
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

    public String getNomePlano() {
        return nomePlano;
    }

    public void setNomePlano(String nomePlano) {
        this.nomePlano = nomePlano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlanoOdontologicoRequestDto entity = (PlanoOdontologicoRequestDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nomePlano, entity.nomePlano) &&
                Objects.equals(this.descricao, entity.descricao) &&
                Objects.equals(this.preco, entity.preco) &&
                Objects.equals(this.validade, entity.validade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomePlano, descricao, preco, validade);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nomePlano = " + nomePlano + ", " +
                "descricao = " + descricao + ", " +
                "preco = " + preco + ", " +
                "validade = " + validade + ")";
    }
}