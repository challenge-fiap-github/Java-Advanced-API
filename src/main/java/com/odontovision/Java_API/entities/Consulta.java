package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "consulta")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    private Dentista dentista;

    @ManyToOne
    @JoinColumn(name = "status_id", nullable = false)
    private StatusConsulta status;

    @ManyToOne
    @JoinColumn(name = "tipo_consulta_id", nullable = false)
    private TipoConsulta tipoConsulta;

    @Size(max = 255)
    private String observacoes;

    public Consulta() {}

    public Consulta(Date dataHora, Usuario usuario, Dentista dentista, StatusConsulta status, TipoConsulta tipoConsulta, String observacoes) {
        this.dataHora = dataHora;
        this.usuario = usuario;
        this.dentista = dentista;
        this.status = status;
        this.tipoConsulta = tipoConsulta;
        this.observacoes = observacoes;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Date getDataHora() { return dataHora; }

    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Dentista getDentista() { return dentista; }

    public void setDentista(Dentista dentista) { this.dentista = dentista; }

    public StatusConsulta getStatus() { return status; }

    public void setStatus(StatusConsulta status) { this.status = status; }

    public TipoConsulta getTipoConsulta() { return tipoConsulta; }

    public void setTipoConsulta(TipoConsulta tipoConsulta) { this.tipoConsulta = tipoConsulta; }

    public String getObservacoes() { return observacoes; }

    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}
