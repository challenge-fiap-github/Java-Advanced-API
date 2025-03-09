package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;

public class UsuarioDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    @Size(min = 6, max = 100)
    private String senha;

    private Date dataNascimento;

    @NotBlank
    @Size(min = 11, max = 11)
    private String cpf;

    private String telefone;

    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String nome, String email, String senha, Date dataNascimento, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 100) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @Size(max = 100) String nome) {
        this.nome = nome;
    }

    public @NotBlank @Email @Size(max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email @Size(max = 100) String email) {
        this.email = email;
    }

    public @Size(min = 6, max = 100) String getSenha() {
        return senha;
    }

    public void setSenha(@Size(min = 6, max = 100) String senha) {
        this.senha = senha;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public @NotBlank @Size(min = 11, max = 11) String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank @Size(min = 11, max = 11) String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
