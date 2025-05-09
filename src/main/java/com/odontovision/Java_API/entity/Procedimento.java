package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PROCEDIMENTO")
public class Procedimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NOME_PROCEDIMENTO", nullable = false, length = 100)
    private String nomeProcedimento;

    @Size(max = 255)
    @Column(name = "DESCRICAO", length = 255)
    private String descricao;

    @Column(name = "CUSTO", precision = 10, scale = 2)
    private BigDecimal custo;

    /** Relação com ConsultaProcedimento (join table) */
    @OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ConsultaProcedimento> consultaProcedimentos = new LinkedHashSet<>();

    /** Relação com HistoricoTratamento */
    @OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HistoricoTratamento> historicoTratamentos = new LinkedHashSet<>();

    /** Relação com PlanoProcedimento (join table) */
    @OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PlanoProcedimento> planoProcedimentos = new LinkedHashSet<>();

    /** Relação com Sinistro */
    @OneToMany(mappedBy = "procedimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sinistro> sinistros = new LinkedHashSet<>();

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProcedimento() {
        return nomeProcedimento;
    }

    public void setNomeProcedimento(String nomeProcedimento) {
        this.nomeProcedimento = nomeProcedimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public Set<ConsultaProcedimento> getConsultaProcedimentos() {
        return consultaProcedimentos;
    }

    public void setConsultaProcedimentos(Set<ConsultaProcedimento> consultaProcedimentos) {
        this.consultaProcedimentos = consultaProcedimentos;
    }

    public Set<HistoricoTratamento> getHistoricoTratamentos() {
        return historicoTratamentos;
    }

    public void setHistoricoTratamentos(Set<HistoricoTratamento> historicoTratamentos) {
        this.historicoTratamentos = historicoTratamentos;
    }

    public Set<PlanoProcedimento> getPlanoProcedimentos() {
        return planoProcedimentos;
    }

    public void setPlanoProcedimentos(Set<PlanoProcedimento> planoProcedimentos) {
        this.planoProcedimentos = planoProcedimentos;
    }

    public Set<Sinistro> getSinistros() {
        return sinistros;
    }

    public void setSinistros(Set<Sinistro> sinistros) {
        this.sinistros = sinistros;
    }

    // equals/hashCode para coleções

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Procedimento)) return false;
        Procedimento that = (Procedimento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}