package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.Instant;

/**
 * Registra operações de INSERT/UPDATE/DELETE nas tabelas do sistema.
 */
@Entity
@Table(name = "AUDITORIA")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @NotNull
    @Size(max = 50)
    @Column(name = "TABELA_AFETADA", nullable = false, length = 50)
    private String tabelaAfetada;

    @NotNull
    @Size(max = 10)
    @Column(name = "TIPO_OPERACAO", nullable = false, length = 10)
    private String tipoOperacao;

    /**
     * Se quiser navegar até o usuário que fez a alteração,
     * substitua por @ManyToOne para Usuario.
     */
    @Column(name = "USUARIO_ID")
    private Long usuarioId;

    @NotNull
    @Column(name = "DATA_OPERACAO", nullable = false, updatable = false)
    private Instant dataOperacao;

    @Lob
    @Column(name = "VALORES_ANTIGOS")
    private String valoresAntigos;

    @Lob
    @Column(name = "VALORES_NOVOS")
    private String valoresNovos;

    @PrePersist
    protected void onCreate() {
        this.dataOperacao = Instant.now();
    }

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
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

    // dataOperacao é somente leitura após inserção

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