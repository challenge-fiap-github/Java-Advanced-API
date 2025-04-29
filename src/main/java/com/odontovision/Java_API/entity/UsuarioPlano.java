package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_PLANO")
public class UsuarioPlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Antes era apenas Long usuarioId; agora relacionamos com Usuario.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    /**
     * Antes era apenas Long planoId; agora relacionamos com PlanoOdontologico.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PLANO_ID", nullable = false)
    private PlanoOdontologico plano;

    @Column(name = "DATA_ADESAO")
    private LocalDate dataAdesao;

    // ======== Getters & Setters ========

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

    public PlanoOdontologico getPlano() {
        return plano;
    }

    public void setPlano(PlanoOdontologico plano) {
        this.plano = plano;
    }

    public LocalDate getDataAdesao() {
        return dataAdesao;
    }

    public void setDataAdesao(LocalDate dataAdesao) {
        this.dataAdesao = dataAdesao;
    }
}