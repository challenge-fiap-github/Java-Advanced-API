package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.PontuacaoController;
import com.odontovision.Java_API.entities.Pontuacao;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.Date;

public class PontuacaoDTO extends RepresentationModel<PontuacaoDTO> {

    private Long id;
    private Long usuarioId;
    private Integer pontos;
    private Date dataRegistro;
    private Date cicloInicial;
    private Date cicloFinal;

    public PontuacaoDTO() {}

    public PontuacaoDTO(Pontuacao pontuacao) {
        this.id = pontuacao.getId();
        this.usuarioId = pontuacao.getUsuario().getId();
        this.pontos = pontuacao.getPontos();
        this.dataRegistro = pontuacao.getDataRegistro();
        this.cicloInicial = pontuacao.getCicloInicial();
        this.cicloFinal = pontuacao.getCicloFinal();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(PontuacaoController.class).buscarPontuacaoPorId(pontuacao.getId())).withSelfRel());
        add(linkTo(methodOn(PontuacaoController.class).listarPontuacoes()).withRel("pontuacoes"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Integer getPontos() { return pontos; }
    public void setPontos(Integer pontos) { this.pontos = pontos; }

    public Date getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(Date dataRegistro) { this.dataRegistro = dataRegistro; }

    public Date getCicloInicial() { return cicloInicial; }
    public void setCicloInicial(Date cicloInicial) { this.cicloInicial = cicloInicial; }

    public Date getCicloFinal() { return cicloFinal; }
    public void setCicloFinal(Date cicloFinal) { this.cicloFinal = cicloFinal; }
}