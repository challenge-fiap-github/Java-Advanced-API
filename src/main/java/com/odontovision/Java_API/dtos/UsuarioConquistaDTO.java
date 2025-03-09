package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.UsuarioConquistaController;
import com.odontovision.Java_API.entities.UsuarioConquista;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class UsuarioConquistaDTO extends RepresentationModel<UsuarioConquistaDTO> {

    private Long usuarioId;
    private Long conquistaId;
    private Date dataObtencao;

    public UsuarioConquistaDTO() {}

    public UsuarioConquistaDTO(UsuarioConquista usuarioConquista) {
        this.usuarioId = usuarioConquista.getUsuario().getId();
        this.conquistaId = usuarioConquista.getConquista().getId();
        this.dataObtencao = usuarioConquista.getDataObtencao();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(UsuarioConquistaController.class)
                .buscarUsuarioConquista(usuarioId, conquistaId)).withSelfRel());
        add(linkTo(methodOn(UsuarioConquistaController.class).listarUsuariosConquistas()).withRel("usuarios-conquistas"));
    }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getConquistaId() { return conquistaId; }
    public void setConquistaId(Long conquistaId) { this.conquistaId = conquistaId; }

    public Date getDataObtencao() { return dataObtencao; }
    public void setDataObtencao(Date dataObtencao) { this.dataObtencao = dataObtencao; }
}