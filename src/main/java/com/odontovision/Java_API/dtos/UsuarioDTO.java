package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.UsuarioController;
import com.odontovision.Java_API.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class UsuarioDTO extends RepresentationModel<UsuarioDTO> {

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

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
        this.cpf = usuario.getCpf();
        this.telefone = usuario.getTelefone();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(UsuarioController.class).buscarUsuarioPorId(usuario.getId())).withSelfRel());
        add(linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios"));
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
}