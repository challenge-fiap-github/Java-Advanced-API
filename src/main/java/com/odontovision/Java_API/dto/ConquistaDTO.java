package com.odontovision.Java_API.dto;

import java.util.Date;

public class ConquistaDTO {

    private Long id;
    private String nome;
    private String descricao;
    private Integer pontosBonus;
    private Date dataExpiracao;

    public ConquistaDTO() {}

    public ConquistaDTO(Long id, String nome, String descricao, Integer pontosBonus, Date dataExpiracao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.pontosBonus = pontosBonus;
        this.dataExpiracao = dataExpiracao;
    }

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

    public Integer getPontosBonus() {
        return pontosBonus;
    }

    public void setPontosBonus(Integer pontosBonus) {
        this.pontosBonus = pontosBonus;
    }

    public Date getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(Date dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }
}
