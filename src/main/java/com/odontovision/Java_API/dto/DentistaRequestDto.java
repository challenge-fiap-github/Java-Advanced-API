package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link com.odontovision.Java_API.entity.Dentista}
 */
public class DentistaRequestDto implements Serializable {
    private final Long id;
    @NotNull
    @Size(max = 100)
    private final String nome;
    @NotNull
    @Size(max = 20)
    private final String cro;
    @Size(max = 100)
    private final String especialidade;
    @Size(max = 15)
    private final String telefone;
    @NotNull
    @Size(max = 100)
    private final String email;

    public DentistaRequestDto(Long id, String nome, String cro, String especialidade, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cro = cro;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCro() {
        return cro;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DentistaRequestDto entity = (DentistaRequestDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.nome, entity.nome) &&
                Objects.equals(this.cro, entity.cro) &&
                Objects.equals(this.especialidade, entity.especialidade) &&
                Objects.equals(this.telefone, entity.telefone) &&
                Objects.equals(this.email, entity.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cro, especialidade, telefone, email);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "nome = " + nome + ", " +
                "cro = " + cro + ", " +
                "especialidade = " + especialidade + ", " +
                "telefone = " + telefone + ", " +
                "email = " + email + ")";
    }
}