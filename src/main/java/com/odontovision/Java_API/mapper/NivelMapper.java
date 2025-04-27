package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.NivelDto;
import com.odontovision.Java_API.entity.Nivel;

public class NivelMapper {

    private NivelMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static NivelDto toResponseDto(Nivel nivel) {
        if (nivel == null) {
            return null;
        }
        return new NivelDto(
                nivel.getId(),
                nivel.getDescricao(),
                nivel.getPontosNecessarios()
        );
    }
}
