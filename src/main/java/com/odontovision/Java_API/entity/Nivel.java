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

    /**
     * Mapeamento bidirecional para UsuarioNivel.
     * "nivel" deve ser o nome do campo em UsuarioNivel que referencia esta entidade.
     */
    @OneToMany(mappedBy = "nivel", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<com.odontovision.Java_API.entity.UsuarioNivel> usuarioNiveis = new LinkedHashSet<>();

    // ======== Getters & Setters ========

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

    public Set<com.odontovision.Java_API.entity.UsuarioNivel> getUsuarioNiveis() {
        return usuarioNiveis;
    }

    public void setUsuarioNiveis(Set<com.odontovision.Java_API.entity.UsuarioNivel> usuarioNiveis) {
        this.usuarioNiveis = usuarioNiveis;
    }
}