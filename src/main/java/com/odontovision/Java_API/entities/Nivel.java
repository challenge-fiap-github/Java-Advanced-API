package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "nivel")
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String descricao;

    @NotNull
    @Column(nullable = false)
    private Integer pontosNecessarios;

    public Nivel() {}

    public Nivel(String descricao, Integer pontosNecessarios) {
        this.descricao = descricao;
        this.pontosNecessarios = pontosNecessarios;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getPontosNecessarios() { return pontosNecessarios; }

    public void setPontosNecessarios(Integer pontosNecessarios) { this.pontosNecessarios = pontosNecessarios; }
}
