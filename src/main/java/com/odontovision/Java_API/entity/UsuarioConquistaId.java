package com.odontovision.Java_API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioConquistaId implements Serializable {
    private static final long serialVersionUID = -1257992147687257025L;
    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "CONQUISTA_ID", nullable = false)
    private Long conquistaId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioConquistaId entity = (UsuarioConquistaId) o;
        return Objects.equals(this.usuarioId, entity.usuarioId) &&
                Objects.equals(this.conquistaId, entity.conquistaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, conquistaId);
    }

}