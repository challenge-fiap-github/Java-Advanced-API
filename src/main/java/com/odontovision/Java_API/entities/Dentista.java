package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "dentista")
public class Dentista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, length = 100)
    private String nome;

    @NotBlank
    @Size(max = 20)
    @Column(nullable = false, unique = true, length = 20)
    private String cro;

    @Size(max = 100)
    private String especialidade;

    @Size(max = 15)
    private String telefone;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    public Dentista() {}

    public Dentista(String nome, String cro, String especialidade, String telefone, String email) {
        this.nome = nome;
        this.cro = cro;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCro() { return cro; }

    public void setCro(String cro) { this.cro = cro; }

    public String getEspecialidade() { return especialidade; }

    public void setEspecialidade(String especialidade) { this.especialidade = especialidade; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }
}
