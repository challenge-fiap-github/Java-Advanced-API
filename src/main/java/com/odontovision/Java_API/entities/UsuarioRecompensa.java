package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario_recompensa")
public class UsuarioRecompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "recompensa_id", nullable = false)
    private Recompensa recompensa;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date dataResgate;

    public UsuarioRecompensa() {}

    public UsuarioRecompensa(Usuario usuario, Recompensa recompensa, Date dataResgate) {
        this.usuario = usuario;
        this.recompensa = recompensa;
        this.dataResgate = dataResgate;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Recompensa getRecompensa() { return recompensa; }

    public void setRecompensa(Recompensa recompensa) { this.recompensa = recompensa; }

    public Date getDataResgate() { return dataResgate; }

    public void setDataResgate(Date dataResgate) { this.dataResgate = dataResgate; }
}
