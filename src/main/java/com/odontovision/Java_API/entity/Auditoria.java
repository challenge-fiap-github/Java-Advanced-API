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

    @Column(name = "ENTIDADE", nullable = false, length = 100)
    private String entidade;

    @Column(name = "ACAO", nullable = false, length = 50)
    private String acao;

    @Column(name = "TIMESTAMP", nullable = false)
    private Instant timestamp;

    @Column(name = "DETALHES", length = 500)
    private String detalhes;

    protected Auditoria() {
        // JPA
    }

    public Auditoria(String entidade, String acao, String detalhes) {
        this.entidade = Objects.requireNonNull(entidade);
        this.acao = Objects.requireNonNull(acao);
        this.detalhes = detalhes;
        this.timestamp = Instant.now();
    }

    // comportamento de exemplo: atualizar detalhes
    public void atualizarDetalhes(String novosDetalhes) {
        this.detalhes = novosDetalhes;
    }

    // getters (somente)
    public Long getId() { return id; }
    public String getEntidade() { return entidade; }
    public String getAcao() { return acao; }
    public Instant getTimestamp() { return timestamp; }
    public String getDetalhes() { return detalhes; }
}