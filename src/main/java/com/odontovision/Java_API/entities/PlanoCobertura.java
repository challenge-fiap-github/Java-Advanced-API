package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "plano_cobertura")
public class PlanoCobertura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_id", nullable = false)
    private PlanoOdontologico planoOdontologico;

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false)
    private String descricao;

    public PlanoCobertura() {}

    public PlanoCobertura(PlanoOdontologico planoOdontologico, String descricao) {
        this.planoOdontologico = planoOdontologico;
        this.descricao = descricao;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public PlanoOdontologico getPlanoOdontologico() { return planoOdontologico; }

    public void setPlanoOdontologico(PlanoOdontologico planoOdontologico) { this.planoOdontologico = planoOdontologico; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }
}
