package com.odontovision.Java_API.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UsuarioConquistaId implements Serializable {

    private Long usuario;
    private Long conquista;

    public UsuarioConquistaId() {}

    public UsuarioConquistaId(Long usuario, Long conquista) {
        this.usuario = usuario;
        this.conquista = conquista;
    }

    public Long getUsuario() { return usuario; }
    public void setUsuario(Long usuario) { this.usuario = usuario; }

    public Long getConquista() { return conquista; }
    public void setConquista(Long conquista) { this.conquista = conquista; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioConquistaId that = (UsuarioConquistaId) o;
        return Objects.equals(usuario, that.usuario) &&
                Objects.equals(conquista, that.conquista);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, conquista);
    }
}