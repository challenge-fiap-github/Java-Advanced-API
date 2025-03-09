package com.odontovision.Java_API.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class DentistaDTO {

    private Long id;

    @NotBlank
    @Size(max = 100)
    private String nome;

    @NotBlank
    @Size(max = 20)
    private String cro;

    @Size(max = 100)
    private String especialidade;

    @Size(max = 15)
    private String telefone;

    @NotBlank
    @Email
    @Size(max = 100)
    private String email;

    public DentistaDTO() {}

    public DentistaDTO(Long id, String nome, String cro, String especialidade, String telefone, String email) {
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

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 100) String getNome() {
        return nome;
    }

    public void setNome(@NotBlank @Size(max = 100) String nome) {
        this.nome = nome;
    }

    public @NotBlank @Size(max = 20) String getCro() {
        return cro;
    }

    public void setCro(@NotBlank @Size(max = 20) String cro) {
        this.cro = cro;
    }

    public @Size(max = 100) String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(@Size(max = 100) String especialidade) {
        this.especialidade = especialidade;
    }

    public @Size(max = 15) String getTelefone() {
        return telefone;
    }

    public void setTelefone(@Size(max = 15) String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank @Email @Size(max = 100) String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @Email @Size(max = 100) String email) {
        this.email = email;
    }
}
