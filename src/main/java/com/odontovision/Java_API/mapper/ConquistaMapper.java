package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ConquistaDto;
import com.odontovision.Java_API.entity.Conquista;

public class ConquistaMapper {

    private ConquistaMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static ConquistaDto toResponseDto(Conquista conquista) {
        if (conquista == null) {
            return null;
        }
        return new ConquistaDto(
                conquista.getId(),
                conquista.getNome(),
                conquista.getDescricao(),
                conquista.getPontosBonus(),
                conquista.getDataExpiracao()
        );
    }
}
