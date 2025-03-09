package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.ConquistaController;
import com.odontovision.Java_API.entities.Conquista;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class ConquistaDTO extends RepresentationModel<ConquistaDTO> {

    private Long id;
    private String nome;
    private String descricao;
    private Integer pontosBonus;
    private Date dataExpiracao;

    public ConquistaDTO() {}

    public ConquistaDTO(Conquista conquista) {
        this.id = conquista.getId();
        this.nome = conquista.getNome();
        this.descricao = conquista.getDescricao();
        this.pontosBonus = conquista.getPontosBonus();
        this.dataExpiracao = conquista.getDataExpiracao();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(ConquistaController.class).buscarConquistaPorId(conquista.getId())).withSelfRel());
        add(linkTo(methodOn(ConquistaController.class).listarConquistas()).withRel("conquistas"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getPontosBonus() { return pontosBonus; }
    public void setPontosBonus(Integer pontosBonus) { this.pontosBonus = pontosBonus; }

    public Date getDataExpiracao() { return dataExpiracao; }
    public void setDataExpiracao(Date dataExpiracao) { this.dataExpiracao = dataExpiracao; }
}