package com.odontovision.Java_API.entity;

import com.odontovision.Java_API.converter.BooleanToCharConverter;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "SINISTRO")
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    /**
     * Antes era pacienteId.
     * Agora mapeamos para a entidade Usuario (o paciente).
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PACIENTE_ID", nullable = false)
    private Usuario paciente;

    /**
     * Antes era procedimentoId.
     * Agora mapeamos para a entidade Procedimento.
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PROCEDIMENTO_ID", nullable = false)
    private Procedimento procedimento;

    @Column(name = "DATA_SINISTRO")
    private LocalDate dataSinistro;

    @Column(name = "RISCO_FRAUDE", length = 1, columnDefinition = "CHAR(1)")
    @Convert(converter = BooleanToCharConverter.class)
    private Boolean riscoFraude;

    @Size(max = 255)
    @Column(name = "DESCRICAO_RISCO", length = 255)
    private String descricaoRisco;

    // ======== Getters & Setters ========

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getPaciente() {
        return paciente;
    }

    public void setPaciente(Usuario paciente) {
        this.paciente = paciente;
    }

    public Procedimento getProcedimento() {
        return procedimento;
    }

    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    public LocalDate getDataSinistro() {
        return dataSinistro;
    }

    public void setDataSinistro(LocalDate dataSinistro) {
        this.dataSinistro = dataSinistro;
    }

    public Boolean getRiscoFraude() {
        return riscoFraude;
    }

    public void setRiscoFraude(Boolean riscoFraude) {
        this.riscoFraude = riscoFraude;
    }

    public String getDescricaoRisco() {
        return descricaoRisco;
    }

    public void setDescricaoRisco(String descricaoRisco) {
        this.descricaoRisco = descricaoRisco;
    }
}