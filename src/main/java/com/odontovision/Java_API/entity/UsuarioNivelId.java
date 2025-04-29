package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioNivelId implements Serializable {
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @Column(name = "NIVEL_ID", nullable = false)
    private Long nivelId;

    // ====== Getters & Setters ======

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

    // ====== equals & hashCode ======

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsuarioNivelId)) return false;
        UsuarioNivelId that = (UsuarioNivelId) o;
        return Objects.equals(usuarioId, that.usuarioId) &&
                Objects.equals(nivelId, that.nivelId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioId, nivelId);
    }
}