package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.DiagnosticoRequestDto;
import com.odontovision.Java_API.dto.DiagnosticoResponseDto;
import com.odontovision.Java_API.entity.Diagnostico;

public class DiagnosticoMapper {

    private DiagnosticoMapper() {
        // Construtor privado para não permitir instanciar
    }

    public static Diagnostico toEntity(DiagnosticoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Diagnostico diagnostico = new Diagnostico();
        diagnostico.setId(dto.getId());
        diagnostico.setConsultaId(dto.getConsultaId());
        diagnostico.setDescricao(dto.getDescricao());
        diagnostico.setData(dto.getData());
        return diagnostico;
    }

    public static DiagnosticoResponseDto toResponseDto(Diagnostico diagnostico) {
        if (diagnostico == null) {
            return null;
        }
        return new DiagnosticoResponseDto(
                diagnostico.getId(),
                diagnostico.getConsultaId(),
                diagnostico.getDescricao(),
                diagnostico.getData()
        );
    }
}
