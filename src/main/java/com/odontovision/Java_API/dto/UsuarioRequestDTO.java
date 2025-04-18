package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Usuario}
 */
public class UsuarioRequestDTO implements Serializable {
    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @Email
    @NotBlank
    @Size(max = 100)
    private String email;

    @NotBlank
    @Size(max = 100)
    private String senha;

    private LocalDate dataNascimento;

    @NotBlank
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @Size(max = 15)
    private String telefone;

    public UsuarioRequestDTO() {
    }

    public UsuarioRequestDTO(Long id, String nome, String email, String senha, LocalDate dataNascimento, String cpf, String telefone) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRequestDTO entity = (UsuarioRequestDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.email, entity.email) &&
                Objects.equals(this.senha, entity.senha) &&
                Objects.equals(this.dataNascimento, entity.dataNascimento) &&
                Objects.equals(this.cpf, entity.cpf) &&
                Objects.equals(this.telefone, entity.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, dataNascimento, cpf, telefone);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "email = " + email + ", " +
                "senha = " + senha + ", " +
                "dataNascimento = " + dataNascimento + ", " +
                "cpf = " + cpf + ", " +
                "telefone = " + telefone + ")";
    }
}