package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.controllers.DentistaController;
import com.odontovision.Java_API.entities.Dentista;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

public class DentistaDTO extends RepresentationModel<DentistaDTO> {

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

    public DentistaDTO(Dentista dentista) {
        this.id = dentista.getId();
        this.nome = dentista.getNome();
        this.cro = dentista.getCro();
        this.especialidade = dentista.getEspecialidade();
        this.telefone = dentista.getTelefone();
        this.email = dentista.getEmail();

        // Adicionando links HATEOAS
        add(linkTo(methodOn(DentistaController.class).buscarDentistaPorId(dentista.getId())).withSelfRel());
        add(linkTo(methodOn(DentistaController.class).listarDentistas()).withRel("dentistas"));
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