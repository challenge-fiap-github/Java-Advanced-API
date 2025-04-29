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
        // extrai o id do usuário a partir da entidade associada
        Long usuarioId = pontuacao.getUsuario() != null
                ? pontuacao.getUsuario().getId()
                : null;

        return new PontuacaoResponseDto(
                pontuacao.getId(),
                usuarioId,
                pontuacao.getPontos(),
                pontuacao.getDataRegistro(),
                pontuacao.getCicloInicial(),
                pontuacao.getCicloFinal()
        );
    }
}