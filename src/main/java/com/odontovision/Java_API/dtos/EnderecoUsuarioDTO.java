package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.EnderecoUsuarioController;
import com.odontovision.Java_API.entities.EnderecoUsuario;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class EnderecoUsuarioDTO extends RepresentationModel<EnderecoUsuarioDTO> {

    private Long id;
    private Long usuarioId;

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

    public EnderecoUsuarioDTO() {}

    public EnderecoUsuarioDTO(EnderecoUsuario enderecoUsuario) {
        this.id = enderecoUsuario.getId();
        this.usuarioId = enderecoUsuario.getUsuario().getId();
        this.logradouro = enderecoUsuario.getLogradouro();
        this.numero = enderecoUsuario.getNumero();
        this.cidade = enderecoUsuario.getCidade();
        this.estado = enderecoUsuario.getEstado();
        this.cep = enderecoUsuario.getCep();
        this.complemento = enderecoUsuario.getComplemento();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(EnderecoUsuarioController.class).buscarEnderecoUsuarioPorId(enderecoUsuario.getId())).withSelfRel());
        add(linkTo(methodOn(EnderecoUsuarioController.class).listarEnderecosUsuario()).withRel("enderecos-usuario"));
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

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