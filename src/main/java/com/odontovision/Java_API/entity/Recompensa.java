package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "RECOMPENSA")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ Para funcionar liso no Docker e bancos em geral
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "PONTOS_NECESSARIOS", nullable = false)
    private Long pontosNecessarios;

    @Column(name = "QUANTIDADE_DISPONIVEL")
    private Long quantidadeDisponivel;

    @Column(name = "DATA_EXPIRACAO")
    private LocalDate dataExpiracao;

    @OneToMany(mappedBy = "recompensa") // ✅ Melhor prática de relacionamento
    private Set<UsuarioRecompensa> usuarioRecompensas = new LinkedHashSet<>();

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

    public Long getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(Long pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }

    public Long getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Long quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public Set<UsuarioRecompensa> getUsuarioRecompensas() {
        return usuarioRecompensas;
    }

    public void setUsuarioRecompensas(Set<UsuarioRecompensa> usuarioRecompensas) {
        this.usuarioRecompensas = usuarioRecompensas;
    }
}
