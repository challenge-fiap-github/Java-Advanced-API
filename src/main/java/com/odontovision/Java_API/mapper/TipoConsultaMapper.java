package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.TipoConsultaDto;
import com.odontovision.Java_API.entity.TipoConsulta;

public class TipoConsultaMapper {

    private TipoConsultaMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static TipoConsultaDto toResponseDto(TipoConsulta tipoConsulta) {
        if (tipoConsulta == null) {
            return null;
        }
        return new TipoConsultaDto(
                tipoConsulta.getId(),
                tipoConsulta.getDescricao()
        );
    }
}
