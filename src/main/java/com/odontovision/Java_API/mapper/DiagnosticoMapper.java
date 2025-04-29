package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.DiagnosticoRequestDto;
import com.odontovision.Java_API.dto.DiagnosticoResponseDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.Diagnostico;

public class DiagnosticoMapper {

    private DiagnosticoMapper() {
        // Construtor privado para não permitir instanciar
    }

    /**
     * Converte o DTO em entidade, criando apenas o stub de Consulta (apenas com ID).
     * A entidade completa de Consulta deve ser buscada no service, ou aceita-se este stub
     * se for suficiente (JPA irá entender que é apenas referência).
     */
    public static Diagnostico toEntity(DiagnosticoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Diagnostico diagnostico = new Diagnostico();
        // Se o DTO tiver id (no update), propague-o
        if (dto.getId() != null) {
            diagnostico.setId(dto.getId());
        }
        // monta um stub de Consulta apenas com ID
        Consulta consulta = new Consulta();
        consulta.setId(dto.getConsultaId());
        diagnostico.setConsulta(consulta);

        diagnostico.setDescricao(dto.getDescricao());
        diagnostico.setData(dto.getData());
        return diagnostico;
    }

    /**
     * Converte entidade em DTO de resposta, extraindo o id da consulta associada.
     */
    public static DiagnosticoResponseDto toResponseDto(Diagnostico diagnostico) {
        if (diagnostico == null) {
            return null;
        }
        return new DiagnosticoResponseDto(
                diagnostico.getId(),
                diagnostico.getConsulta().getId(),
                diagnostico.getDescricao(),
                diagnostico.getData()
        );
    }
}