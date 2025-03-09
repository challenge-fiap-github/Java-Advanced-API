package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.ConsultaController;
import com.odontovision.Java_API.entities.Consulta;
import jakarta.validation.constraints.NotNull;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class ConsultaDTO extends RepresentationModel<ConsultaDTO> {

    private Long id;

    @NotNull
    private Long usuarioId;

    @NotNull
    private Long dentistaId;

    @NotNull
    private Long statusId;

    @NotNull
    private Long tipoConsultaId;

    private Date dataHora;
    private String observacoes;

    public ConsultaDTO() {}

    public ConsultaDTO(Consulta consulta) {
        this.id = consulta.getId();
        this.usuarioId = consulta.getUsuario().getId();
        this.dentistaId = consulta.getDentista().getId();
        this.statusId = consulta.getStatus().getId();
        this.tipoConsultaId = consulta.getTipoConsulta().getId();
        this.dataHora = consulta.getDataHora();
        this.observacoes = consulta.getObservacoes();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(ConsultaController.class).buscarConsultaPorId(consulta.getId())).withSelfRel());
        add(linkTo(methodOn(ConsultaController.class).listarConsultas()).withRel("consultas"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Long getDentistaId() { return dentistaId; }
    public void setDentistaId(Long dentistaId) { this.dentistaId = dentistaId; }

    public Long getStatusId() { return statusId; }
    public void setStatusId(Long statusId) { this.statusId = statusId; }

    public Long getTipoConsultaId() { return tipoConsultaId; }
    public void setTipoConsultaId(Long tipoConsultaId) { this.tipoConsultaId = tipoConsultaId; }

    public Date getDataHora() { return dataHora; }
    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }
}