package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.ValidacaoChecklistController;
import com.odontovision.Java_API.entities.ValidacaoChecklist;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class ValidacaoChecklistDTO extends RepresentationModel<ValidacaoChecklistDTO> {

    private Long id;
    private Long usuarioId;
    private Long consultaId;
    private Date dataValidacao;
    private char statusValidacao;
    private Integer pontosBonus;

    public ValidacaoChecklistDTO() {}

    public ValidacaoChecklistDTO(ValidacaoChecklist validacaoChecklist) {
        this.id = validacaoChecklist.getId();
        this.usuarioId = validacaoChecklist.getUsuario().getId();
        this.consultaId = validacaoChecklist.getConsulta().getId();
        this.dataValidacao = validacaoChecklist.getDataValidacao();
        this.statusValidacao = validacaoChecklist.getStatusValidacao();
        this.pontosBonus = validacaoChecklist.getPontosBonus();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(ValidacaoChecklistController.class).buscarValidacaoChecklist(id)).withSelfRel());
        add(linkTo(methodOn(ValidacaoChecklistController.class).listarValidacoesChecklist()).withRel("validacoes-checklist"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getConsultaId() { return consultaId; }
    public void setConsultaId(Long consultaId) { this.consultaId = consultaId; }

    public Date getDataValidacao() { return dataValidacao; }
    public void setDataValidacao(Date dataValidacao) { this.dataValidacao = dataValidacao; }

    public char getStatusValidacao() { return statusValidacao; }
    public void setStatusValidacao(char statusValidacao) { this.statusValidacao = statusValidacao; }

    public Integer getPontosBonus() { return pontosBonus; }
    public void setPontosBonus(Integer pontosBonus) { this.pontosBonus = pontosBonus; }
}