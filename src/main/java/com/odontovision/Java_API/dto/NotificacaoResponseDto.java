package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Notificacao}
 */
public class NotificacaoResponseDto implements Serializable {
    private final Long id;

    @NotNull
    @Size(max = 100)
    private final String titulo;

    @NotNull
    @Size(max = 255)
    private final String conteudo;

    @NotNull
    private final Instant dataEnvio;

    @NotNull
    private final Long usuarioId;

    public NotificacaoResponseDto(Long id,
                                  String titulo,
                                  String conteudo,
                                  Instant dataEnvio,
                                  Long usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public Instant getDataEnvio() {
        return dataEnvio;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotificacaoResponseDto)) return false;
        NotificacaoResponseDto that = (NotificacaoResponseDto) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(conteudo, that.conteudo) &&
                Objects.equals(dataEnvio, that.dataEnvio) &&
                Objects.equals(usuarioId, that.usuarioId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, conteudo, dataEnvio, usuarioId);
    }

    @Override
    public String toString() {
        return "NotificacaoResponseDto{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", conteudo='" + conteudo + '\'' +
                ", dataEnvio=" + dataEnvio +
                ", usuarioId=" + usuarioId +
                '}';
    }
}