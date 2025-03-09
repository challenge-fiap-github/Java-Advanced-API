package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "endereco_clinica")
public class EnderecoClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    private Dentista dentista;

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

    public EnderecoClinica() {}

    public EnderecoClinica(Dentista dentista, String logradouro, String numero, String cidade, String estado, String cep, String complemento) {
        this.dentista = dentista;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.complemento = complemento;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Dentista getDentista() { return dentista; }

    public void setDentista(Dentista dentista) { this.dentista = dentista; }

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
