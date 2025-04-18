package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "DIAGNOSTICO", schema = "RM553568")
public class Diagnostico {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DIAGNOSTICO_id_gen")
    @SequenceGenerator(name = "DIAGNOSTICO_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "CONSULTA_ID", nullable = false)
    private Long consultaId;

    @Size(max = 255)
    @NotNull
    @Column(name = "DESCRICAO", nullable = false)
    private String descricao;

    @NotNull
    @Column(name = "\"DATA\"", nullable = false)
    private LocalDate data;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

}