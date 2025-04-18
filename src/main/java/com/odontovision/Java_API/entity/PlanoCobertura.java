package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "PLANO_COBERTURA", schema = "RM553568")
public class PlanoCobertura {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLANO_COBERTURA_id_gen")
    @SequenceGenerator(name = "PLANO_COBERTURA_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "PLANO_ID", nullable = false)
    private Long planoId;

    @Size(max = 255)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanoId() {
        return planoId;
    }

    public void setPlanoId(Long planoId) {
        this.planoId = planoId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}