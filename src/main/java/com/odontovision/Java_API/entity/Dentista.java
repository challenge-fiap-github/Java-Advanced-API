package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "DENTISTA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_CRO", columnNames = {"CRO"}),
        @UniqueConstraint(name = "UK_EMAIL", columnNames = {"EMAIL"})
})
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Size(max = 20)
    @NotNull
    @Column(name = "CRO", nullable = false, length = 20)
    private String cro;

    @Size(max = 100)
    @Column(name = "ESPECIALIDADE", length = 100)
    private String especialidade;

    @Size(max = 15)
    @Column(name = "TELEFONE", length = 15)
    private String telefone;

    @Size(max = 100)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Consulta> consultas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EnderecoClinica> enderecoClinicas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<HistoricoTratamento> historicoTratamentos = new LinkedHashSet<>();

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Set<EnderecoClinica> getEnderecoClinicas() {
        return enderecoClinicas;
    }

    public void setEnderecoClinicas(Set<EnderecoClinica> enderecoClinicas) {
        this.enderecoClinicas = enderecoClinicas;
    }

    public Set<HistoricoTratamento> getHistoricoTratamentos() {
        return historicoTratamentos;
    }

    public void setHistoricoTratamentos(Set<HistoricoTratamento> historicoTratamentos) {
        this.historicoTratamentos = historicoTratamentos;
    }
}