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

    /** Agora o relacionamento está invertido: mappedBy="plano" */
    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlanoCobertura> planoCoberturas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlanoProcedimento> planoProcedimentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<UsuarioPlano> usuarioPlanos = new LinkedHashSet<>();

    // ======= Getters e Setters =======

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

    public Set<PlanoProcedimento> getPlanoProcedimentos() {
        return planoProcedimentos;
    }

    public void setPlanoProcedimentos(Set<PlanoProcedimento> planoProcedimentos) {
        this.planoProcedimentos = planoProcedimentos;
    }

    public Set<UsuarioPlano> getUsuarioPlanos() {
        return usuarioPlanos;
    }

    public void setUsuarioPlanos(Set<UsuarioPlano> usuarioPlanos) {
        this.usuarioPlanos = usuarioPlanos;
    }
}