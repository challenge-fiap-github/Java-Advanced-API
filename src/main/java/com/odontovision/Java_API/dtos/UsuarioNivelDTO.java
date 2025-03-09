package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.UsuarioNivelController;
import com.odontovision.Java_API.entities.UsuarioNivel;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class UsuarioNivelDTO extends RepresentationModel<UsuarioNivelDTO> {

    private Long usuarioId;
    private Long nivelId;
    private Integer pontosAtuais;
    private Date dataUltimaAtualizacao;

    public UsuarioNivelDTO() {}

    public UsuarioNivelDTO(UsuarioNivel usuarioNivel) {
        this.usuarioId = usuarioNivel.getUsuario().getId();
        this.nivelId = usuarioNivel.getNivel().getId();
        this.pontosAtuais = usuarioNivel.getPontosAtuais();
        this.dataUltimaAtualizacao = usuarioNivel.getDataUltimaAtualizacao();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(UsuarioNivelController.class)
                .buscarUsuarioNivel(usuarioId, nivelId)).withSelfRel());
        add(linkTo(methodOn(UsuarioNivelController.class).listarUsuariosNiveis()).withRel("usuarios-niveis"));
    }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getNivelId() { return nivelId; }
    public void setNivelId(Long nivelId) { this.nivelId = nivelId; }

    public Integer getPontosAtuais() { return pontosAtuais; }
    public void setPontosAtuais(Integer pontosAtuais) { this.pontosAtuais = pontosAtuais; }

    public Date getDataUltimaAtualizacao() { return dataUltimaAtualizacao; }
    public void setDataUltimaAtualizacao(Date dataUltimaAtualizacao) { this.dataUltimaAtualizacao = dataUltimaAtualizacao; }
}