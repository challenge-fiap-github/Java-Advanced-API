package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "historico_tratamento")
public class HistoricoTratamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "procedimento_id", nullable = false)
    private Procedimento procedimento;

    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    private Dentista dentista;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    @NotBlank
    @Column(length = 255)
    private String observacoes;

    public HistoricoTratamento() {}

    public HistoricoTratamento(Usuario usuario, Procedimento procedimento, Dentista dentista, Date data, String observacoes) {
        this.usuario = usuario;
        this.procedimento = procedimento;
        this.dentista = dentista;
        this.data = data;
        this.observacoes = observacoes;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Procedimento getProcedimento() { return procedimento; }

    public void setProcedimento(Procedimento procedimento) { this.procedimento = procedimento; }

    public Dentista getDentista() { return dentista; }

    public void setDentista(Dentista dentista) { this.dentista = dentista; }

    public Date getData() { return data; }

    public void setData(Date data) { this.data = data; }

    public String getObservacoes() { return observacoes; }

    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
