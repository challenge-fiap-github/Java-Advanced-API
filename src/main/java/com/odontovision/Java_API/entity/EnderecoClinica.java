package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

/**
 * Agora mapeado corretamente para Dentista em vez de usar apenas o ID.
 */
@Entity
@Table(name = "ENDERECO_CLINICA")
public class EnderecoClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Relação Many-to-One com Dentista
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DENTISTA_ID", nullable = false)
    private Dentista dentista;

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

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
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