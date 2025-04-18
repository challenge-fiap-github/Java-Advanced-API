package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "STATUS_CONSULTA", schema = "RM553568", uniqueConstraints = {
        @UniqueConstraint(name = "SYS_C004485639", columnNames = {"DESCRICAO"})
})
public class StatusConsulta {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATUS_CONSULTA_id_gen")
    @SequenceGenerator(name = "STATUS_CONSULTA_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 20)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false, length = 20)
    private String descricao;

    @OneToMany
    @JoinColumn
    private Set<Consulta> consultas = new LinkedHashSet<>();

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