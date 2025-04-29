package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Representa o histórico de tratamentos realizados por um usuário,
 * associando usuário, procedimento, dentista e data da realização.
 */
@Entity
@Table(name = "HISTORICO_TRATAMENTO")
public class HistoricoTratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /** Usuário que realizou o tratamento */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    /** Procedimento aplicado */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PROCEDIMENTO_ID", nullable = false)
    private Procedimento procedimento;

    /** Dentista que executou o procedimento */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DENTISTA_ID", nullable = false)
    private Dentista dentista;

    /** Data em que o tratamento ocorreu */
    @NotNull
    @Column(name = "DATA", nullable = false)
    private LocalDate data;

    /** Observações adicionais sobre o tratamento */
    @Size(max = 255)
    @Column(name = "OBSERVACOES", length = 255)
    private String observacoes;

    /** Construtor padrão para JPA */
    protected HistoricoTratamento() {}

    /** Construtor de conveniência */
    public HistoricoTratamento(Usuario usuario, Procedimento procedimento, Dentista dentista, LocalDate data, String observacoes) {
        this.usuario = usuario;
        this.procedimento = procedimento;
        this.dentista = dentista;
        this.data = data;
        this.observacoes = observacoes;
    }

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }
    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public Dentista getDentista() {
        return dentista;
    }
    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}