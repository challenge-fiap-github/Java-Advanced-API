package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.PlanoOdontologicoController;
import com.odontovision.Java_API.entities.PlanoOdontologico;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class PlanoOdontologicoDTO extends RepresentationModel<PlanoOdontologicoDTO> {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nomePlano;

    @Size(max = 255)
    private String descricao;

    @DecimalMin("0.00")
    private Double preco;

    private Date validade;

    public PlanoOdontologicoDTO() {}

    public PlanoOdontologicoDTO(PlanoOdontologico plano) {
        this.id = plano.getId();
        this.nomePlano = plano.getNomePlano();
        this.descricao = plano.getDescricao();
        this.preco = plano.getPreco();
        this.validade = plano.getValidade();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(PlanoOdontologicoController.class).buscarPlanoPorId(plano.getId())).withSelfRel());
        add(linkTo(methodOn(PlanoOdontologicoController.class).listarPlanos()).withRel("planos-odontologicos"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomePlano() { return nomePlano; }
    public void setNomePlano(String nomePlano) { this.nomePlano = nomePlano; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getPreco() { return preco; }
    public void setPreco(Double preco) { this.preco = preco; }

    public Date getValidade() { return validade; }
    public void setValidade(Date validade) { this.validade = validade; }
}