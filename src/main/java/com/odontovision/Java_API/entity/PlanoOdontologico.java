package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "PLANO_ODONTOLOGICO")
public class PlanoOdontologico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NOME_PLANO", nullable = false, length = 100)
    private String nomePlano;

    @Size(max = 255)
    @Column(name = "DESCRICAO")
    private String descricao;

    @Column(name = "PRECO", precision = 10, scale = 2)
    private BigDecimal preco;

    @Column(name = "VALIDADE")
    private LocalDate validade;

    @OneToMany
    @JoinColumn
    private Set<PlanoCobertura> planoCoberturas = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.PlanoProcedimento> planoProcedimentos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.UsuarioPlano> usuarioPlanos = new LinkedHashSet<>();
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

    public Set<PlanoCobertura> getPlanoCoberturas() {
        return planoCoberturas;
    }

    public void setPlanoCoberturas(Set<PlanoCobertura> planoCoberturas) {
        this.planoCoberturas = planoCoberturas;
    }

    public Set<com.odontovision.Java_API.entity.PlanoProcedimento> getPlanoProcedimentos() {
        return planoProcedimentos;
    }

    public void setPlanoProcedimentos(Set<com.odontovision.Java_API.entity.PlanoProcedimento> planoProcedimentos) {
        this.planoProcedimentos = planoProcedimentos;
    }

    public Set<com.odontovision.Java_API.entity.UsuarioPlano> getUsuarioPlanos() {
        return usuarioPlanos;
    }

    public void setUsuarioPlanos(Set<com.odontovision.Java_API.entity.UsuarioPlano> usuarioPlanos) {
        this.usuarioPlanos = usuarioPlanos;
    }

}