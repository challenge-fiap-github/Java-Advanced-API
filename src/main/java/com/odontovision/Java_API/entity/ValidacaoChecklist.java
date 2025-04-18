package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "VALIDACAO_CHECKLIST", schema = "RM553568")
public class ValidacaoChecklist {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "VALIDACAO_CHECKLIST_id_gen")
    @SequenceGenerator(name = "VALIDACAO_CHECKLIST_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "USUARIO_ID", nullable = false)
    private Long usuarioId;

    @NotNull
    @Column(name = "CONSULTA_ID", nullable = false)
    private Long consultaId;

    @ColumnDefault("CURRENT_DATE")
    @Column(name = "DATA_VALIDACAO")
    private LocalDate dataValidacao;

    @Column(name = "STATUS_VALIDACAO")
    private Boolean statusValidacao;

    @Column(name = "PONTOS_BONUS")
    private Long pontosBonus;

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