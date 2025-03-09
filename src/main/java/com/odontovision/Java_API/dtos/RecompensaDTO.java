package com.odontovision.Java_API.dtos;

import java.util.Date;

public class RecompensaDTO {

    private Long id;
    private String descricao;
    private Integer pontosNecessarios;
    private Integer quantidadeDisponivel;
    private Date dataExpiracao;

    public RecompensaDTO() {}

    public RecompensaDTO(Long id, String descricao, Integer pontosNecessarios, Integer quantidadeDisponivel, Date dataExpiracao) {
        this.id = id;
        this.descricao = descricao;
        this.pontosNecessarios = pontosNecessarios;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.dataExpiracao = dataExpiracao;
    }

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

    public Integer getPontosNecessarios() {
        return pontosNecessarios;
    }

    public void setPontosNecessarios(Integer pontosNecessarios) {
        this.pontosNecessarios = pontosNecessarios;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
