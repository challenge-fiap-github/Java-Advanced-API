package com.odontovision.Java_API.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioNivelId implements Serializable {

    private Long usuario;
    private Long nivel;

    public UsuarioNivelId() {}

    public UsuarioNivelId(Long usuario, Long nivel) {
        this.usuario = usuario;
        this.nivel = nivel;
    }

    public Long getUsuario() { return usuario; }
    public void setUsuario(Long usuario) { this.usuario = usuario; }

    public Long getNivel() { return nivel; }
    public void setNivel(Long nivel) { this.nivel = nivel; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioNivelId that = (UsuarioNivelId) o;
        return Objects.equals(usuario, that.usuario) &&
                Objects.equals(nivel, that.nivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, nivel);
    }
}