package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TIPO_CONSULTA")
public class TipoConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mudança aqui
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false, length = 50)
    private String descricao;

    @OneToMany
    @JoinColumn
    private Set<Consulta> consultas = new LinkedHashSet<>();

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
}
