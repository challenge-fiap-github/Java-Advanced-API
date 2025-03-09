package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

@Entity
@Table(name = "conquista")
public class Conquista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String descricao;

    private Integer pontosBonus;

    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;

    public Conquista() {}

    public Conquista(String nome, String descricao, Integer pontosBonus, Date dataExpiracao) {
        this.nome = nome;
        this.descricao = descricao;
        this.pontosBonus = pontosBonus;
        this.dataExpiracao = dataExpiracao;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getPontosBonus() { return pontosBonus; }

    public void setPontosBonus(Integer pontosBonus) { this.pontosBonus = pontosBonus; }

    public Date getDataExpiracao() { return dataExpiracao; }

    public void setDataExpiracao(Date dataExpiracao) { this.dataExpiracao = dataExpiracao; }
}
