package com.odontovision.Java_API.entity;

import com.odontovision.Java_API.converter.BooleanToCharConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "VALIDACAO_CHECKLIST")
public class ValidacaoChecklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Antes era apenas Long usuarioId;
     * Agora mapeado para a entidade Usuario.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USUARIO_ID", nullable = false)
    private Usuario usuario;

    /**
     * Antes era apenas Long consultaId;
     * Agora mapeado para a entidade Consulta.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CONSULTA_ID", nullable = false)
    private Consulta consulta;

    @Column(name = "DATA_VALIDACAO")
    private LocalDate dataValidacao;

    @Column(name = "STATUS_VALIDACAO", length = 1, columnDefinition = "CHAR(1)")
    @Convert(converter = BooleanToCharConverter.class)
    private Boolean statusValidacao;

    @Column(name = "PONTOS_BONUS")
    private Long pontosBonus;

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
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