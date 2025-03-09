package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.ProcedimentoController;
import com.odontovision.Java_API.entities.Procedimento;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class ProcedimentoDTO extends RepresentationModel<ProcedimentoDTO> {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nomeProcedimento;

    @Size(max = 255)
    private String descricao;

    @DecimalMin("0.00")
    private Double custo;

    public ProcedimentoDTO() {}

    public ProcedimentoDTO(Procedimento procedimento) {
        this.id = procedimento.getId();
        this.nomeProcedimento = procedimento.getNomeProcedimento();
        this.descricao = procedimento.getDescricao();
        this.custo = procedimento.getCusto();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(ProcedimentoController.class).buscarProcedimentoPorId(procedimento.getId())).withSelfRel());
        add(linkTo(methodOn(ProcedimentoController.class).listarProcedimentos()).withRel("procedimentos"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeProcedimento() { return nomeProcedimento; }
    public void setNomeProcedimento(String nomeProcedimento) { this.nomeProcedimento = nomeProcedimento; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getCusto() { return custo; }
    public void setCusto(Double custo) { this.custo = custo; }
}