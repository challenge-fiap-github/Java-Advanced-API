package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.StatusConsultaDto;
import com.odontovision.Java_API.entity.StatusConsulta;

public class StatusConsultaMapper {

    private StatusConsultaMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static StatusConsultaDto toResponseDto(StatusConsulta statusConsulta) {
        if (statusConsulta == null) {
            return null;
        }
        return new StatusConsultaDto(
                statusConsulta.getId(),
                statusConsulta.getDescricao()
        );
    }
}
