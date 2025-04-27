package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.RecompensaResponseDto;
import com.odontovision.Java_API.entity.Recompensa;

public class RecompensaMapper {

    private RecompensaMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static RecompensaResponseDto toResponseDto(Recompensa recompensa) {
        if (recompensa == null) {
            return null;
        }
        return new RecompensaResponseDto(
                recompensa.getId(),
                recompensa.getDescricao(),
                recompensa.getPontosNecessarios(),
                recompensa.getQuantidadeDisponivel(),
                recompensa.getDataExpiracao()
        );
    }
}
