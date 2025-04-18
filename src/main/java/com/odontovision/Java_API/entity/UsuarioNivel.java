package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_NIVEL", schema = "RM553568")
public class UsuarioNivel {
    @SequenceGenerator(name = "USUARIO_NIVEL_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @EmbeddedId
    private UsuarioNivelId id;

    @NotNull
    @Column(name = "PONTOS_ATUAIS", nullable = false)
    private Long pontosAtuais;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "DATA_ULTIMA_ATUALIZACAO")
    private LocalDate dataUltimaAtualizacao;

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