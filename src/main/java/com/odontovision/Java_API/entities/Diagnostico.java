package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "consulta_id", nullable = false)
    private Consulta consulta;

    @NotBlank
    @Column(nullable = false, length = 255)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    public Diagnostico() {}

    public Diagnostico(Consulta consulta, String descricao, Date data) {
        this.consulta = consulta;
        this.descricao = descricao;
        this.data = data;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Consulta getConsulta() { return consulta; }

    public void setConsulta(Consulta consulta) { this.consulta = consulta; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Date getData() { return data; }

    public void setData(Date data) { this.data = data; }
}
