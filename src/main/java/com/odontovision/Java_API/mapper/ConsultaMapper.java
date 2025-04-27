package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ConsultaRequestDto;
import com.odontovision.Java_API.dto.ConsultaResponseDto;
import com.odontovision.Java_API.entity.Consulta;

public class ConsultaMapper {

    private ConsultaMapper() {
        // Construtor privado para não permitir instanciar
    }

    public static Consulta toEntity(ConsultaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setUsuarioId(dto.getUsuarioId());
        consulta.setDentistaId(dto.getDentistaId());
        consulta.setStatusId(dto.getStatusId());
        consulta.setTipoConsultaId(dto.getTipoConsultaId());
        consulta.setObservacoes(dto.getObservacoes());
        return consulta;
    }

    public static ConsultaResponseDto toResponseDto(Consulta consulta) {
        if (consulta == null) {
            return null;
        }
        return new ConsultaResponseDto(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getUsuarioId(),
                consulta.getDentistaId(),
                consulta.getStatusId(),
                consulta.getTipoConsultaId(),
                consulta.getObservacoes()
        );
    }
}
