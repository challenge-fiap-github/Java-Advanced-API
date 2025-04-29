package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CONQUISTA")
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Size(max = 255)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false, length = 255)
    private String descricao;

    @Column(name = "PONTOS_BONUS")
    private Long pontosBonus;

    @Column(name = "DATA_EXPIRACAO")
    private LocalDate dataExpiracao;

    /**
     * Bidirecional com UsuarioConquista.
     * Quando uma conquista é removida, todos os registros de usuário-conquista
     * relacionados serão removidos também.
     */
    @OneToMany(
            mappedBy = "conquista",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<UsuarioConquista> usuarioConquistas = new LinkedHashSet<>();

    // ======= Getters & Setters =======

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getPontosBonus() {
        return pontosBonus;
    }

    public void setPontosBonus(Long pontosBonus) {
        this.pontosBonus = pontosBonus;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Set<UsuarioConquista> getUsuarioConquistas() {
        return usuarioConquistas;
    }

    public void setUsuarioConquistas(Set<UsuarioConquista> usuarioConquistas) {
        this.usuarioConquistas = usuarioConquistas;
    }
}