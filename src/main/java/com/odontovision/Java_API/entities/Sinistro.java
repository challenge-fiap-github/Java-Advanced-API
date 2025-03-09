package com.odontovision.Java_API.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "sinistro")
public class Sinistro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Usuario paciente;

    @ManyToOne
    @JoinColumn(name = "procedimento_id", nullable = false)
    private Procedimento procedimento;

    @Temporal(TemporalType.DATE)
    private Date dataSinistro;

    @NotBlank
    @Size(min = 1, max = 1)
    @Column(nullable = false)
    private String riscoFraude; // 'S' ou 'N'

    @Size(max = 255)
    private String descricaoRisco;

    public Sinistro() {}

    public Sinistro(Usuario paciente, Procedimento procedimento, Date dataSinistro, String riscoFraude, String descricaoRisco) {
        this.paciente = paciente;
        this.procedimento = procedimento;
        this.dataSinistro = dataSinistro;
        this.riscoFraude = riscoFraude;
        this.descricaoRisco = descricaoRisco;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Usuario getPaciente() { return paciente; }

    public void setPaciente(Usuario paciente) { this.paciente = paciente; }

    public Procedimento getProcedimento() { return procedimento; }

    public void setProcedimento(Procedimento procedimento) { this.procedimento = procedimento; }

    public Date getDataSinistro() { return dataSinistro; }

    public void setDataSinistro(Date dataSinistro) { this.dataSinistro = dataSinistro; }

    public String getRiscoFraude() { return riscoFraude; }

    public void setRiscoFraude(String riscoFraude) { this.riscoFraude = riscoFraude; }

    public String getDescricaoRisco() { return descricaoRisco; }

    public void setDescricaoRisco(String descricaoRisco) { this.descricaoRisco = descricaoRisco; }
}
