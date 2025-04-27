package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "VALIDACAO_CHECKLIST")
public class ValidacaoChecklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Corrigido para IDENTITY
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "CONSULTA_ID", nullable = false)
    private Long consultaId;

    @Column(name = "DATA_VALIDACAO")
    private LocalDate dataValidacao;

    @Column(name = "STATUS_VALIDACAO")
    private Boolean statusValidacao;

    @Column(name = "PONTOS_BONUS")
    private Long pontosBonus;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(Long consultaId) {
        this.consultaId = consultaId;
    }

    public LocalDate getDataValidacao() {
        return dataValidacao;
    }

    public void setDataValidacao(LocalDate dataValidacao) {
        this.dataValidacao = dataValidacao;
    }

    public Boolean getStatusValidacao() {
        return statusValidacao;
    }

    public void setStatusValidacao(Boolean statusValidacao) {
        this.statusValidacao = statusValidacao;
    }

    public Long getPontosBonus() {
        return pontosBonus;
    }

    public void setPontosBonus(Long pontosBonus) {
        this.pontosBonus = pontosBonus;
    }
}
