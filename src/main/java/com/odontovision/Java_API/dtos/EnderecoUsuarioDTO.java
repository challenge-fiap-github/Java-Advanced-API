package com.odontovision.Java_API.dtos;

import jakarta.validation.constraints.Size;

public class EnderecoUsuarioDTO {

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

    public EnderecoUsuarioDTO(Long id, Long usuarioId, String logradouro, String numero, String cidade, String estado, String cep, String complemento) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public @Size(max = 150) String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(@Size(max = 150) String logradouro) {
        this.logradouro = logradouro;
    }

    public @Size(max = 10) String getNumero() {
        return numero;
    }

    public void setNumero(@Size(max = 10) String numero) {
        this.numero = numero;
    }

    public @Size(max = 100) String getCidade() {
        return cidade;
    }

    public void setCidade(@Size(max = 100) String cidade) {
        this.cidade = cidade;
    }

    public @Size(max = 50) String getEstado() {
        return estado;
    }

    public void setEstado(@Size(max = 50) String estado) {
        this.estado = estado;
    }

    public @Size(max = 10) String getCep() {
        return cep;
    }

    public void setCep(@Size(max = 10) String cep) {
        this.cep = cep;
    }

    public @Size(max = 100) String getComplemento() {
        return complemento;
    }

    public void setComplemento(@Size(max = 100) String complemento) {
        this.complemento = complemento;
    }
}
