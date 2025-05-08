package com.odontovision.Java_API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioConquistaId implements Serializable {
    private static final long serialVersionUID = -1257992147687257025L;

    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @Column(name = "CONQUISTA_ID", nullable = false)
    private Long conquistaId;

    public UsuarioConquistaId() {}

    public UsuarioConquistaId(Long usuarioId, Long conquistaId) {
        this.usuarioId = usuarioId;
        this.conquistaId = conquistaId;
    }

    // Getters & setters

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getConquistaId() {
        return conquistaId;
    }

    public void setConquistaId(Long conquistaId) {
        this.conquistaId = conquistaId;
    }

    // equals() e hashCode()

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioConquistaId)) return false;
        UsuarioConquistaId that = (UsuarioConquistaId) o;
        return Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(conquistaId, that.conquistaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, conquistaId);
    }
}