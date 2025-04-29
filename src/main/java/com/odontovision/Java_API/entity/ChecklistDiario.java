package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "CHECKLIST_DIARIO")
public class ChecklistDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Associação com Usuário.
     * Antes tínhamos apenas usuarioId, agora navegamos diretamente para a entidade.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    @NotNull
    @Column(name = "DATA", nullable = false)
    private LocalDate data;

    @Column(name = "ESCOVACAO")
    private Boolean escovacao;

    @Column(name = "FIO_DENTAL")
    private Boolean fioDental;

    /**
     * Associação com Consulta para validação.
     * Antes tínhamos apenas consultaValidacaoId, agora navegamos diretamente para a entidade.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CONSULTA_VALIDACAO_ID")
    private Consulta consulta;

    // ================================
    // Getters e Setters
    // ================================

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Boolean getEscovacao() {
        return escovacao;
    }

    public void setEscovacao(Boolean escovacao) {
        this.escovacao = escovacao;
    }

    public Boolean getFioDental() {
        return fioDental;
    }

    public void setFioDental(Boolean fioDental) {
        this.fioDental = fioDental;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
}