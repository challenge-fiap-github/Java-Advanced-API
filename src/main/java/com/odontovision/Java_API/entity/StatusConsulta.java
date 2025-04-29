package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "STATUS_CONSULTA")
public class StatusConsulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 20)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false, length = 20)
    private String descricao;

    /**
     * Agora mapeado por 'statusConsulta' na Consulta.
     */
    @OneToMany(mappedBy = "statusConsulta", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Consulta> consultas = new LinkedHashSet<>();

    // getters & setters

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