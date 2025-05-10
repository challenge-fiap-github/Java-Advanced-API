package com.odontovision.Java_API.entity;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "AUDITORIA")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TABELA_AFETADA", nullable = false, length = 50)
    private String tabelaAfetada;

    @Column(name = "TIPO_OPERACAO", nullable = false, length = 10)
    private String tipoOperacao;

    @Column(name = "USUARIO_ID")
    private Long usuarioId;

    @Column(name = "DATA_OPERACAO", nullable = false)
    private Instant dataOperacao;

    @Lob
    @Column(name = "VALORES_ANTIGOS")
    private String valoresAntigos;

    @Lob
    @Column(name = "VALORES_NOVOS")
    private String valoresNovos;

    protected Auditoria() {
        // JPA
    }

    public Auditoria(String tabelaAfetada,
                     String tipoOperacao,
                     Long usuarioId,
                     String valoresAntigos,
                     String valoresNovos) {
        this.tabelaAfetada  = Objects.requireNonNull(tabelaAfetada);
        this.tipoOperacao   = Objects.requireNonNull(tipoOperacao);
        this.usuarioId      = usuarioId;
        this.valoresAntigos = valoresAntigos;
        this.valoresNovos   = valoresNovos;
        this.dataOperacao   = Instant.now();
    }

    public Long    getId()             { return id; }
    public String  getTabelaAfetada()  { return tabelaAfetada; }
    public String  getTipoOperacao()   { return tipoOperacao; }
    public Long    getUsuarioId()      { return usuarioId; }
    public Instant getDataOperacao()   { return dataOperacao; }
    public String  getValoresAntigos() { return valoresAntigos; }
    public String  getValoresNovos()   { return valoresNovos; }
}
