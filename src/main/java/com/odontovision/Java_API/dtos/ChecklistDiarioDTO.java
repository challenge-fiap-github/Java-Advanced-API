package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.ChecklistDiarioController;
import com.odontovision.Java_API.entities.ChecklistDiario;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ChecklistDiarioDTO extends RepresentationModel<ChecklistDiarioDTO> {

    private Long id;

    @NotNull
    private Long usuarioId;

    @NotNull
    private Date data;

    @NotNull
    private char escovacao;

    @NotNull
    private char fioDental;

    private Long consultaValidacaoId;

    public ChecklistDiarioDTO() {}

    public ChecklistDiarioDTO(ChecklistDiario checklist) {
        this.id = checklist.getId();
        this.usuarioId = checklist.getUsuario().getId();
        this.data = checklist.getData();
        this.escovacao = checklist.getEscovacao();
        this.fioDental = checklist.getFioDental();
        this.consultaValidacaoId = checklist.getConsultaValidacao() != null ? checklist.getConsultaValidacao().getId() : null;

        // Adicionando links HATEOAS
        add(linkTo(methodOn(ChecklistDiarioController.class).buscarChecklistPorId(checklist.getId())).withSelfRel());
        add(linkTo(methodOn(ChecklistDiarioController.class).listarChecklists()).withRel("checklists"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public char getEscovacao() { return escovacao; }
    public void setEscovacao(char escovacao) { this.escovacao = escovacao; }

    public char getFioDental() { return fioDental; }
    public void setFioDental(char fioDental) { this.fioDental = fioDental; }

    public Long getConsultaValidacaoId() { return consultaValidacaoId; }
    public void setConsultaValidacaoId(Long consultaValidacaoId) { this.consultaValidacaoId = consultaValidacaoId; }
}