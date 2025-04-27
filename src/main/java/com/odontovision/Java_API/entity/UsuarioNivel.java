package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_NIVEL", schema = "RM553568")
public class UsuarioNivel {

    @EmbeddedId
    private UsuarioNivelId id;

    @Column(name = "PONTOS_ATUAIS", nullable = false)
    private Long pontosAtuais;

    @Column(name = "DATA_ULTIMA_ATUALIZACAO")
    private LocalDate dataUltimaAtualizacao;

    // GETTERS E SETTERS

    public UsuarioNivelId getId() {
        return id;
    }

    public void setId(UsuarioNivelId id) {
        this.id = id;
    }

    public Long getPontosAtuais() {
        return pontosAtuais;
    }

    public void setPontosAtuais(Long pontosAtuais) {
        this.pontosAtuais = pontosAtuais;
    }

    public LocalDate getDataUltimaAtualizacao() {
        return dataUltimaAtualizacao;
    }

    public void setDataUltimaAtualizacao(LocalDate dataUltimaAtualizacao) {
        this.dataUltimaAtualizacao = dataUltimaAtualizacao;
    }
}
