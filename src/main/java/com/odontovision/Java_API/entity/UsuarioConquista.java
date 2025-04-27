package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_CONQUISTA")
public class UsuarioConquista {

    @EmbeddedId
    private UsuarioConquistaId id;

    @Column(name = "DATA_OBTENCAO")
    private LocalDate dataObtencao;

    // GETTERS E SETTERS

    public UsuarioConquistaId getId() {
        return id;
    }

    public void setId(UsuarioConquistaId id) {
        this.id = id;
    }

    public LocalDate getDataObtencao() {
        return dataObtencao;
    }

    public void setDataObtencao(LocalDate dataObtencao) {
        this.dataObtencao = dataObtencao;
    }
}
