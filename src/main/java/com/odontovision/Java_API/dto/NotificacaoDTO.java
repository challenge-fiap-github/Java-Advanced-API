package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotBlank;
import java.util.Date;

public class NotificacaoDTO {

    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String conteudo;

    private Date dataEnvio;

    private Long usuarioId;

    public NotificacaoDTO() {}

    public NotificacaoDTO(Long id, String titulo, String conteudo, Date dataEnvio, Long usuarioId) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.dataEnvio = dataEnvio;
        this.usuarioId = usuarioId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public @NotBlank String getConteudo() {
        return conteudo;
    }

    public void setConteudo(@NotBlank String conteudo) {
        this.conteudo = conteudo;
    }

    public Date getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(Date dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
