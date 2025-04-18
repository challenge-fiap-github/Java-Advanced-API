package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "AUDITORIA", schema = "RM553568")
public class Auditoria {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AUDITORIA_id_gen")
    @SequenceGenerator(name = "AUDITORIA_id_gen", sequenceName = "ISEQ$$_2717013", allocationSize = 1)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "TABELA_AFETADA", nullable = false, length = 50)
    private String tabelaAfetada;

    @Size(max = 10)
    @NotNull
    @Column(name = "TIPO_OPERACAO", nullable = false, length = 10)
    private String tipoOperacao;

    @Column(name = "USUARIO_ID")
    private Long usuarioId;

    @ColumnDefault("SYSTIMESTAMP")
    @Column(name = "DATA_OPERACAO")
    private Instant dataOperacao;

    @Lob
    @Column(name = "VALORES_ANTIGOS")
    private String valoresAntigos;

    @Lob
    @Column(name = "VALORES_NOVOS")
    private String valoresNovos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTabelaAfetada() {
        return tabelaAfetada;
    }

    public void setTabelaAfetada(String tabelaAfetada) {
        this.tabelaAfetada = tabelaAfetada;
    }

    public String getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(String tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Instant getDataOperacao() {
        return dataOperacao;
    }

    public void setDataOperacao(Instant dataOperacao) {
        this.dataOperacao = dataOperacao;
    }

    public String getValoresAntigos() {
        return valoresAntigos;
    }

    public void setValoresAntigos(String valoresAntigos) {
        this.valoresAntigos = valoresAntigos;
    }

    public String getValoresNovos() {
        return valoresNovos;
    }

    public void setValoresNovos(String valoresNovos) {
        this.valoresNovos = valoresNovos;
    }

}