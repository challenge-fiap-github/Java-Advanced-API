package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "PLANO_COBERTURA")
public class PlanoCobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Mapeamento para PlanoOdontologico.
     * O nome do campo deve bater com o mappedBy em PlanoOdontologico (mappedBy="plano").
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PLANO_ID", nullable = false)
    private PlanoOdontologico plano;

    @Size(max = 255)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlanoOdontologico getPlano() {
        return plano;
    }

    public void setPlano(PlanoOdontologico plano) {
        this.plano = plano;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // ======== equals & hashCode ========

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlanoCobertura that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}