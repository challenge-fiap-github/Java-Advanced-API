package com.odontovision.Java_API.dtos;

public class NivelDTO {

    private Long id;
    private String descricao;
    private Integer pontosNecessarios;

    public NivelDTO() {}

    public NivelDTO(Long id, String descricao, Integer pontosNecessarios) {
        this.id = id;
        this.descricao = descricao;
        this.pontosNecessarios = pontosNecessarios;
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
}
