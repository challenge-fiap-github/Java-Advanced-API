package com.odontovision.Java_API.dtos;

import com.odontovision.Java_API.entities.Consulta;
import com.odontovision.Java_API.entities.Usuario;
import java.util.Date;

public class ChecklistDiarioDTO {

    private Long id;
    private Usuario usuario;
    private Date data;
    private char escovacao;
    private char fioDental;
    private Consulta consultaValidacao;

    public ChecklistDiarioDTO() {}

    public ChecklistDiarioDTO(Long id, Usuario usuario, Date data, char escovacao, char fioDental, Consulta consultaValidacao) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.escovacao = escovacao;
        this.fioDental = fioDental;
        this.consultaValidacao = consultaValidacao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }

    public char getEscovacao() { return escovacao; }
    public void setEscovacao(char escovacao) { this.escovacao = escovacao; }

    public char getFioDental() { return fioDental; }
    public void setFioDental(char fioDental) { this.fioDental = fioDental; }

    public Consulta getConsultaValidacao() { return consultaValidacao; }
    public void setConsultaValidacao(Consulta consultaValidacao) { this.consultaValidacao = consultaValidacao; }
}