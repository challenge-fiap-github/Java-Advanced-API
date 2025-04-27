package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.NotificacaoResponseDto;
import com.odontovision.Java_API.entity.Notificacao;

public class NotificacaoMapper {

    private NotificacaoMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static NotificacaoResponseDto toResponseDto(Notificacao notificacao) {
        if (notificacao == null) {
            return null;
        }
        return new NotificacaoResponseDto(
                notificacao.getId(),
                notificacao.getTitulo(),
                notificacao.getConteudo(),
                notificacao.getDataEnvio(),
                notificacao.getUsuarioId()
        );
    }
}
