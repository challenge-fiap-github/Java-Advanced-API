package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.NotificacaoController;
import com.odontovision.Java_API.entities.Notificacao;
import jakarta.validation.constraints.NotBlank;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class NotificacaoDTO extends RepresentationModel<NotificacaoDTO> {

    private Long id;

    @NotBlank
    private String titulo;

    @NotBlank
    private String conteudo;

    private Date dataEnvio;

    private Long usuarioId;

    public NotificacaoDTO() {}

    public NotificacaoDTO(Notificacao notificacao) {
        this.id = notificacao.getId();
        this.titulo = notificacao.getTitulo();
        this.conteudo = notificacao.getConteudo();
        this.dataEnvio = notificacao.getDataEnvio();
        this.usuarioId = notificacao.getUsuario().getId();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(NotificacaoController.class).buscarNotificacaoPorId(notificacao.getId())).withSelfRel());
        add(linkTo(methodOn(NotificacaoController.class).listarNotificacoes()).withRel("notificacoes"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public Date getDataEnvio() { return dataEnvio; }
    public void setDataEnvio(Date dataEnvio) { this.dataEnvio = dataEnvio; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}