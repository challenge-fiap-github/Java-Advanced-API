package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank
    @Size(min = 6, max = 100)
    @Column(nullable = false, length = 100)
    private String senha;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotBlank
    @Size(min = 11, max = 11)
    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Size(max = 15)
    private String telefone;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnderecoUsuario> enderecos;

    public Usuario() {}

    public Usuario(String nome, String email, String senha, Date dataNascimento, String cpf, String telefone) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public Date getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public List<EnderecoUsuario> getEnderecos() { return enderecos; }

    public void setEnderecos(List<EnderecoUsuario> enderecos) { this.enderecos = enderecos; }
}
