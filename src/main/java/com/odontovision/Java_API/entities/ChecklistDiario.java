package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "checklist_diario")
public class ChecklistDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    @Column(nullable = false)
    private char escovacao; // 'S' ou 'N'

    @Column(nullable = false)
    private char fioDental; // 'S' ou 'N'

    @ManyToOne
    @JoinColumn(name = "consulta_validacao_id")
    private Consulta consultaValidacao;

    public ChecklistDiario() {}

    public ChecklistDiario(Usuario usuario, Date data, char escovacao, char fioDental, Consulta consultaValidacao) {
        this.usuario = usuario;
        this.data = data;
        this.escovacao = escovacao;
        this.fioDental = fioDental;
        this.consultaValidacao = consultaValidacao;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Date getData() { return data; }

    public void setData(Date data) { this.data = data; }

    public char getEscovacao() { return escovacao; }

    public void setEscovacao(char escovacao) { this.escovacao = escovacao; }

    public char getFioDental() { return fioDental; }

    public void setFioDental(char fioDental) { this.fioDental = fioDental; }

    public Consulta getConsultaValidacao() { return consultaValidacao; }

    public void setConsultaValidacao(Consulta consultaValidacao) { this.consultaValidacao = consultaValidacao; }
}
