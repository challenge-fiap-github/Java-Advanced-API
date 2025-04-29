package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.SinistroResponseDto;
import com.odontovision.Java_API.entity.Sinistro;

public class SinistroMapper {

    private SinistroMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static SinistroResponseDto toResponseDto(Sinistro sinistro) {
        if (sinistro == null) {
            return null;
        }
        return new SinistroResponseDto(
                sinistro.getId(),
                sinistro.getPaciente().getId(),        // antes era getPacienteId()
                sinistro.getProcedimento().getId(),    // antes era getProcedimentoId()
                sinistro.getDataSinistro(),
                sinistro.getRiscoFraude(),
                sinistro.getDescricaoRisco()
        );
    }
}