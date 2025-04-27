package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 100)
    @NotNull
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;

    @Size(max = 100)
    @NotNull
    @Column(name = "EMAIL", nullable = false, length = 100, unique = true)
    private String email;

    @Size(max = 100)
    @NotNull
    @Column(name = "SENHA", nullable = false, length = 100)
    private String senha;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataNascimento;

    @Size(max = 11)
    @NotNull
    @Column(name = "CPF", nullable = false, length = 11, unique = true)
    private String cpf;

    @Size(max = 15)
    @Column(name = "TELEFONE", length = 15)
    private String telefone;

    @OneToMany(mappedBy = "usuario")
    private Set<ChecklistDiario> checklistDiarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Consulta> consultas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<EnderecoUsuario> enderecoUsuarios = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<HistoricoPontuacao> historicoPontuacoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<HistoricoTratamento> historicoTratamentos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Notificacao> notificacoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Pontuacao> pontuacoes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<Sinistro> sinistros = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioConquista> usuarioConquistas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioNivel> usuarioNiveis = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioPlano> usuarioPlanos = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<UsuarioRecompensa> usuarioRecompensas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "usuario")
    private Set<ValidacaoChecklist> validacaoChecklists = new LinkedHashSet<>();

    // GETTERS E SETTERS

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(LocalDate dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public Set<ChecklistDiario> getChecklistDiarios() { return checklistDiarios; }

    public void setChecklistDiarios(Set<ChecklistDiario> checklistDiarios) { this.checklistDiarios = checklistDiarios; }

    public Set<Consulta> getConsultas() { return consultas; }

    public void setConsultas(Set<Consulta> consultas) { this.consultas = consultas; }

    public Set<EnderecoUsuario> getEnderecoUsuarios() { return enderecoUsuarios; }

    public void setEnderecoUsuarios(Set<EnderecoUsuario> enderecoUsuarios) { this.enderecoUsuarios = enderecoUsuarios; }

    public Set<HistoricoPontuacao> getHistoricoPontuacoes() { return historicoPontuacoes; }

    public void setHistoricoPontuacoes(Set<HistoricoPontuacao> historicoPontuacoes) { this.historicoPontuacoes = historicoPontuacoes; }

    public Set<HistoricoTratamento> getHistoricoTratamentos() { return historicoTratamentos; }

    public void setHistoricoTratamentos(Set<HistoricoTratamento> historicoTratamentos) { this.historicoTratamentos = historicoTratamentos; }

    public Set<Notificacao> getNotificacoes() { return notificacoes; }

    public void setNotificacoes(Set<Notificacao> notificacoes) { this.notificacoes = notificacoes; }

    public Set<Pontuacao> getPontuacoes() { return pontuacoes; }

    public void setPontuacoes(Set<Pontuacao> pontuacoes) { this.pontuacoes = pontuacoes; }

    public Set<Sinistro> getSinistros() { return sinistros; }

    public void setSinistros(Set<Sinistro> sinistros) { this.sinistros = sinistros; }

    public Set<UsuarioConquista> getUsuarioConquistas() { return usuarioConquistas; }

    public void setUsuarioConquistas(Set<UsuarioConquista> usuarioConquistas) { this.usuarioConquistas = usuarioConquistas; }

    public Set<UsuarioNivel> getUsuarioNiveis() { return usuarioNiveis; }

    public void setUsuarioNiveis(Set<UsuarioNivel> usuarioNiveis) { this.usuarioNiveis = usuarioNiveis; }

    public Set<UsuarioPlano> getUsuarioPlanos() { return usuarioPlanos; }

    public void setUsuarioPlanos(Set<UsuarioPlano> usuarioPlanos) { this.usuarioPlanos = usuarioPlanos; }

    public Set<UsuarioRecompensa> getUsuarioRecompensas() { return usuarioRecompensas; }

    public void setUsuarioRecompensas(Set<UsuarioRecompensa> usuarioRecompensas) { this.usuarioRecompensas = usuarioRecompensas; }

    public Set<ValidacaoChecklist> getValidacaoChecklists() { return validacaoChecklists; }

    public void setValidacaoChecklists(Set<ValidacaoChecklist> validacaoChecklists) { this.validacaoChecklists = validacaoChecklists; }
}
