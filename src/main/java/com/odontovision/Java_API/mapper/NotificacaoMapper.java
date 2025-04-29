package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.NotificacaoResponseDto;
import com.odontovision.Java_API.entity.Notificacao;

public final class NotificacaoMapper {

    private NotificacaoMapper() {
        // utilitário estático
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
                notificacao.getUsuario().getId()      // <— aqui pegamos o id do usuário
        );
    }
}
