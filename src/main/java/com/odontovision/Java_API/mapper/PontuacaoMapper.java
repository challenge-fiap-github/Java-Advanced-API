package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.PontuacaoResponseDto;
import com.odontovision.Java_API.entity.Pontuacao;

public class PontuacaoMapper {

    private PontuacaoMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static PontuacaoResponseDto toResponseDto(Pontuacao pontuacao) {
        if (pontuacao == null) {
            return null;
        }
        return new PontuacaoResponseDto(
                pontuacao.getId(),
                pontuacao.getUsuarioId(),
                pontuacao.getPontos(),
                pontuacao.getDataRegistro(),
                pontuacao.getCicloInicial(),
                pontuacao.getCicloFinal()
        );
    }
}
