package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.RecompensaController;
import com.odontovision.Java_API.entities.Recompensa;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class RecompensaDTO extends RepresentationModel<RecompensaDTO> {

    private Long id;
    private String descricao;
    private Integer pontosNecessarios;
    private Integer quantidadeDisponivel;
    private Date dataExpiracao;

    public RecompensaDTO() {}

    public RecompensaDTO(Recompensa recompensa) {
        this.id = recompensa.getId();
        this.descricao = recompensa.getDescricao();
        this.pontosNecessarios = recompensa.getPontosNecessarios();
        this.quantidadeDisponivel = recompensa.getQuantidadeDisponivel();
        this.dataExpiracao = recompensa.getDataExpiracao();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(RecompensaController.class).buscarRecompensaPorId(recompensa.getId())).withSelfRel());
        add(linkTo(methodOn(RecompensaController.class).listarRecompensas()).withRel("recompensas"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Integer getPontosNecessarios() { return pontosNecessarios; }
    public void setPontosNecessarios(Integer pontosNecessarios) { this.pontosNecessarios = pontosNecessarios; }

    public Integer getQuantidadeDisponivel() { return quantidadeDisponivel; }
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) { this.quantidadeDisponivel = quantidadeDisponivel; }

    public Date getDataExpiracao() { return dataExpiracao; }
    public void setDataExpiracao(Date dataExpiracao) { this.dataExpiracao = dataExpiracao; }
}