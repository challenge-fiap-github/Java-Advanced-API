package com.odontovision.Java_API.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioNivelId implements Serializable {
    private static final long serialVersionUID = -5176883195219479580L;
    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "NIVEL_ID", nullable = false)
    private Long nivelId;

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getNivelId() {
        return nivelId;
    }

    public void setNivelId(Long nivelId) {
        this.nivelId = nivelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        UsuarioNivelId entity = (UsuarioNivelId) o;
        return Objects.equals(this.nivelId, entity.nivelId) &&
                Objects.equals(this.usuarioId, entity.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nivelId, usuarioId);
    }

}