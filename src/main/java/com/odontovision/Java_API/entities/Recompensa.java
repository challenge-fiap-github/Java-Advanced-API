package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "recompensa")
public class Recompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String descricao;

    @Column(nullable = false)
    private Integer pontosNecessarios;

    private Integer quantidadeDisponivel;

    @Temporal(TemporalType.DATE)
    private Date dataExpiracao;

    public Recompensa() {}

    public Recompensa(String descricao, Integer pontosNecessarios, Integer quantidadeDisponivel, Date dataExpiracao) {
        this.descricao = descricao;
        this.pontosNecessarios = pontosNecessarios;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataExpiracao = dataExpiracao;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getPontosNecessarios() { return pontosNecessarios; }

    public void setPontosNecessarios(Integer pontosNecessarios) { this.pontosNecessarios = pontosNecessarios; }

    public Integer getQuantidadeDisponivel() { return quantidadeDisponivel; }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) { this.quantidadeDisponivel = quantidadeDisponivel; }

    public Date getDataExpiracao() { return dataExpiracao; }

    public void setDataExpiracao(Date dataExpiracao) { this.dataExpiracao = dataExpiracao; }
}
