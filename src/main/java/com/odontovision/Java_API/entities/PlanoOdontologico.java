package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "plano_odontologico")
public class PlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nomePlano;

    @Size(max = 255)
    private String descricao;

    @DecimalMin("0.00")
    @Column(precision = 10, scale = 2)
    private Double preco;

    @Temporal(TemporalType.DATE)
    private Date validade;

    public PlanoOdontologico() {}

    public PlanoOdontologico(String nomePlano, String descricao, Double preco, Date validade) {
        this.nomePlano = nomePlano;
        this.descricao = descricao;
        this.preco = preco;
        this.validade = validade;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNomePlano() { return nomePlano; }

    public void setNomePlano(String nomePlano) { this.nomePlano = nomePlano; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }

    public void setPreco(Double preco) { this.preco = preco; }

    public Date getValidade() { return validade; }

    public void setValidade(Date validade) { this.validade = validade; }
}
