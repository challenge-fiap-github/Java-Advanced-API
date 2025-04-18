package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "ENDERECO_USUARIO", schema = "RM553568")
public class EnderecoUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENDERECO_USUARIO_id_gen")
    @SequenceGenerator(name = "ENDERECO_USUARIO_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @Size(max = 150)
    @Column(name = "LOGRADOURO", length = 150)
    private String logradouro;

    @Size(max = 10)
    @Column(name = "NUMERO", length = 10)
    private String numero;

    @Size(max = 100)
    @Column(name = "CIDADE", length = 100)
    private String cidade;

    @Size(max = 50)
    @Column(name = "ESTADO", length = 50)
    private String estado;

    @Size(max = 10)
    @Column(name = "CEP", length = 10)
    private String cep;

    @Size(max = 100)
    @Column(name = "COMPLEMENTO", length = 100)
    private String complemento;

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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

}