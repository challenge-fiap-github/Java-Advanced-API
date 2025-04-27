package com.odontovision.Java_API.entity;

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

    @Column(name = "PACIENTE_ID")
    private Long pacienteId;

    @Column(name = "PROCEDIMENTO_ID")
    private Long procedimentoId;

    @Column(name = "DATA_SINISTRO")
    private LocalDate dataSinistro;

    @Column(name = "RISCO_FRAUDE")
    private Boolean riscoFraude;

    @Size(max = 255)
    @Column(name = "DESCRICAO_RISCO")
    private String descricaoRisco;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(Long pacienteId) {
        this.pacienteId = pacienteId;
    }

    public Long getProcedimentoId() {
        return procedimentoId;
    }

    public void setProcedimentoId(Long procedimentoId) {
        this.procedimentoId = procedimentoId;
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
