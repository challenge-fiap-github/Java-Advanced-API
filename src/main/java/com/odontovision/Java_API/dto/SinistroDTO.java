package com.odontovision.Java_API.dto;

import java.util.Date;

public class SinistroDTO {

    private Long id;
    private Long pacienteId;
    private Long procedimentoId;
    private Date dataSinistro;
    private char riscoFraude; // 'S' ou 'N'
    private String descricaoRisco;

    public SinistroDTO() {}

    public SinistroDTO(Long id, Long pacienteId, Long procedimentoId, Date dataSinistro, char riscoFraude, String descricaoRisco) {
        this.id = id;
        this.pacienteId = pacienteId;
        this.procedimentoId = procedimentoId;
        this.dataSinistro = dataSinistro;
        this.riscoFraude = riscoFraude;
        this.descricaoRisco = descricaoRisco;
    }

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

    public Date getDataSinistro() {
        return dataSinistro;
    }

    public void setDataSinistro(Date dataSinistro) {
        this.dataSinistro = dataSinistro;
    }

    public char getRiscoFraude() {
        return riscoFraude;
    }

    public void setRiscoFraude(char riscoFraude) {
        this.riscoFraude = riscoFraude;
    }

    public String getDescricaoRisco() {
        return descricaoRisco;
    }

    public void setDescricaoRisco(String descricaoRisco) {
        this.descricaoRisco = descricaoRisco;
    }
}
