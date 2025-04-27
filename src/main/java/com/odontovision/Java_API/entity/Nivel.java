package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "NIVEL")
public class Nivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false, length = 100)
    private String descricao;

    @NotNull
    @Column(name = "PONTOS_NECESSARIOS", nullable = false)
    private Long pontosNecessarios;

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.UsuarioNivel> usuarioNivels = new LinkedHashSet<>();

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

    public Long getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(Long pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }

    public Set<com.odontovision.Java_API.entity.UsuarioNivel> getUsuarioNivels() {
        return usuarioNivels;
    }

    public void setUsuarioNivels(Set<com.odontovision.Java_API.entity.UsuarioNivel> usuarioNivels) {
        this.usuarioNivels = usuarioNivels;
    }

}