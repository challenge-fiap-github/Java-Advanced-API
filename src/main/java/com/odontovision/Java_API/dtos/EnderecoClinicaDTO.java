package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.EnderecoClinicaController;
import com.odontovision.Java_API.entities.EnderecoClinica;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class EnderecoClinicaDTO extends RepresentationModel<EnderecoClinicaDTO> {

    private Long id;
    private Long dentistaId;

    @Size(max = 150)
    private String logradouro;

    @Size(max = 10)
    private String numero;

    @Size(max = 100)
    private String cidade;

    @Size(max = 50)
    private String estado;

    @Size(max = 10)
    private String cep;

    @Size(max = 100)
    private String complemento;

    public EnderecoClinicaDTO() {}

    public EnderecoClinicaDTO(EnderecoClinica enderecoClinica) {
        this.id = enderecoClinica.getId();
        this.dentistaId = enderecoClinica.getDentista().getId();
        this.logradouro = enderecoClinica.getLogradouro();
        this.numero = enderecoClinica.getNumero();
        this.cidade = enderecoClinica.getCidade();
        this.estado = enderecoClinica.getEstado();
        this.cep = enderecoClinica.getCep();
        this.complemento = enderecoClinica.getComplemento();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(EnderecoClinicaController.class).buscarEnderecoClinicaPorId(enderecoClinica.getId())).withSelfRel());
        add(linkTo(methodOn(EnderecoClinicaController.class).listarEnderecosClinica()).withRel("enderecos-clinica"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getDentistaId() { return dentistaId; }
    public void setDentistaId(Long dentistaId) { this.dentistaId = dentistaId; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }
}