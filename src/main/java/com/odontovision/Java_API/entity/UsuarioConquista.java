package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "USUARIO_CONQUISTA", schema = "RM553568")
public class UsuarioConquista {
    @SequenceGenerator(name = "USUARIO_CONQUISTA_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @EmbeddedId
    private UsuarioConquistaId id;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "DATA_OBTENCAO")
    private LocalDate dataObtencao;

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