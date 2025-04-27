package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_RECOMPENSA")
public class UsuarioRecompensa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @ManyToOne(fetch = FetchType.LAZY) // Relação forte e eficiente
    @JoinColumn(name = "RECOMPENSA_ID", nullable = false)
    private Recompensa recompensa;

    @Column(name = "DATA_RESGATE")
    private LocalDate dataResgate;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Recompensa getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensa recompensa) {
        this.recompensa = recompensa;
    }

    public LocalDate getDataResgate() {
        return dataResgate;
    }

    public void setDataResgate(LocalDate dataResgate) {
        this.dataResgate = dataResgate;
    }
}
