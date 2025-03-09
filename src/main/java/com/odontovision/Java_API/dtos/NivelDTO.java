package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.NivelController;
import com.odontovision.Java_API.entities.Nivel;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class NivelDTO extends RepresentationModel<NivelDTO> {

    private Long id;
    private String descricao;
    private Integer pontosNecessarios;

    public NivelDTO() {}

    public NivelDTO(Nivel nivel) {
        this.id = nivel.getId();
        this.descricao = nivel.getDescricao();
        this.pontosNecessarios = nivel.getPontosNecessarios();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(NivelController.class).buscarNivelPorId(nivel.getId())).withSelfRel());
        add(linkTo(methodOn(NivelController.class).listarNiveis()).withRel("niveis"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getPontosNecessarios() { return pontosNecessarios; }
    public void setPontosNecessarios(Integer pontosNecessarios) { this.pontosNecessarios = pontosNecessarios; }
}