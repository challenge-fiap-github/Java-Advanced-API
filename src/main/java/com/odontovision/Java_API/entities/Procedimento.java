package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "procedimento")
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nomeProcedimento;

    @Size(max = 255)
    private String descricao;

    @DecimalMin("0.00")
    @Column(precision = 10, scale = 2)
    private Double custo;

    public Procedimento() {}

    public Procedimento(String nomeProcedimento, String descricao, Double custo) {
        this.nomeProcedimento = nomeProcedimento;
        this.descricao = descricao;
        this.custo = custo;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNomeProcedimento() { return nomeProcedimento; }

    public void setNomeProcedimento(String nomeProcedimento) { this.nomeProcedimento = nomeProcedimento; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getCusto() { return custo; }

    public void setCusto(Double custo) { this.custo = custo; }
}
