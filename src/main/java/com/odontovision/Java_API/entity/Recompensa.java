package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "RECOMPENSA", schema = "RM553568")
public class Recompensa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECOMPENSA_id_gen")
    @SequenceGenerator(name = "RECOMPENSA_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "PONTOS_NECESSARIOS", nullable = false)
    private Long pontosNecessarios;

    @Column(name = "QUANTIDADE_DISPONIVEL")
    private Long quantidadeDisponivel;

    @Column(name = "DATA_EXPIRACAO")
    private LocalDate dataExpiracao;

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.UsuarioRecompensa> usuarioRecompensas = new LinkedHashSet<>();

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

    public Set<com.odontovision.Java_API.entity.UsuarioRecompensa> getUsuarioRecompensas() {
        return usuarioRecompensas;
    }

    public void setUsuarioRecompensas(Set<com.odontovision.Java_API.entity.UsuarioRecompensa> usuarioRecompensas) {
        this.usuarioRecompensas = usuarioRecompensas;
    }

}