package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "USUARIO", schema = "RM553568", uniqueConstraints = {
        @UniqueConstraint(name = "SYS_C004485451", columnNames = {"EMAIL"}),
        @UniqueConstraint(name = "SYS_C004485452", columnNames = {"CPF"})
})
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIO_id_gen")
    @SequenceGenerator(name = "USUARIO_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Size(max = 100)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 100)
    private String email;

    @Size(max = 100)
    @NotNull
    @Column(name = "SENHA", nullable = false, length = 100)
    private String senha;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Size(max = 11)
    @NotNull
    @Column(name = "CPF", nullable = false, length = 11)
    private String cpf;

    @Size(max = 15)
    @Column(name = "TELEFONE", length = 15)
    private String telefone;

    @OneToMany
    @JoinColumn
    private Set<ChecklistDiario> checklistDiarios = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<Consulta> consultas = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<EnderecoUsuario> enderecoUsuarios = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<HistoricoPontuacao> historicoPontuacaos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<HistoricoTratamento> historicoTratamentos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<Notificacao> notificacaos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<Pontuacao> pontuacaos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<Sinistro> sinistros = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.UsuarioConquista> usuarioConquistas = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.UsuarioNivel> usuarioNivels = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.UsuarioPlano> usuarioPlanos = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.UsuarioRecompensa> usuarioRecompensas = new LinkedHashSet<>();

    @OneToMany
    @JoinColumn
    private Set<com.odontovision.Java_API.entity.ValidacaoChecklist> validacaoChecklists = new LinkedHashSet<>();

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Set<ChecklistDiario> getChecklistDiarios() {
        return checklistDiarios;
    }

    public void setChecklistDiarios(Set<ChecklistDiario> checklistDiarios) {
        this.checklistDiarios = checklistDiarios;
    }

    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }

    public Set<EnderecoUsuario> getEnderecoUsuarios() {
        return enderecoUsuarios;
    }

    public void setEnderecoUsuarios(Set<EnderecoUsuario> enderecoUsuarios) {
        this.enderecoUsuarios = enderecoUsuarios;
    }

    public Set<HistoricoPontuacao> getHistoricoPontuacaos() {
        return historicoPontuacaos;
    }

    public void setHistoricoPontuacaos(Set<HistoricoPontuacao> historicoPontuacaos) {
        this.historicoPontuacaos = historicoPontuacaos;
    }

    public Set<HistoricoTratamento> getHistoricoTratamentos() {
        return historicoTratamentos;
    }

    public void setHistoricoTratamentos(Set<HistoricoTratamento> historicoTratamentos) {
        this.historicoTratamentos = historicoTratamentos;
    }

    public Set<Notificacao> getNotificacaos() {
        return notificacaos;
    }

    public void setNotificacaos(Set<Notificacao> notificacaos) {
        this.notificacaos = notificacaos;
    }

    public Set<Pontuacao> getPontuacaos() {
        return pontuacaos;
    }

    public void setPontuacaos(Set<Pontuacao> pontuacaos) {
        this.pontuacaos = pontuacaos;
    }

    public Set<Sinistro> getSinistros() {
        return sinistros;
    }

    public void setSinistros(Set<Sinistro> sinistros) {
        this.sinistros = sinistros;
    }

    public Set<com.odontovision.Java_API.entity.UsuarioConquista> getUsuarioConquistas() {
        return usuarioConquistas;
    }

    public void setUsuarioConquistas(Set<com.odontovision.Java_API.entity.UsuarioConquista> usuarioConquistas) {
        this.usuarioConquistas = usuarioConquistas;
    }

    public Set<com.odontovision.Java_API.entity.UsuarioNivel> getUsuarioNivels() {
        return usuarioNivels;
    }

    public void setUsuarioNivels(Set<com.odontovision.Java_API.entity.UsuarioNivel> usuarioNivels) {
        this.usuarioNivels = usuarioNivels;
    }

    public Set<com.odontovision.Java_API.entity.UsuarioPlano> getUsuarioPlanos() {
        return usuarioPlanos;
    }

    public void setUsuarioPlanos(Set<com.odontovision.Java_API.entity.UsuarioPlano> usuarioPlanos) {
        this.usuarioPlanos = usuarioPlanos;
    }

    public Set<com.odontovision.Java_API.entity.UsuarioRecompensa> getUsuarioRecompensas() {
        return usuarioRecompensas;
    }

    public void setUsuarioRecompensas(Set<com.odontovision.Java_API.entity.UsuarioRecompensa> usuarioRecompensas) {
        this.usuarioRecompensas = usuarioRecompensas;
    }

    public Set<com.odontovision.Java_API.entity.ValidacaoChecklist> getValidacaoChecklists() {
        return validacaoChecklists;
    }

    public void setValidacaoChecklists(Set<com.odontovision.Java_API.entity.ValidacaoChecklist> validacaoChecklists) {
        this.validacaoChecklists = validacaoChecklists;
    }

}