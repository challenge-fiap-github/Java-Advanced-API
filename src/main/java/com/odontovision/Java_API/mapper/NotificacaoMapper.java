package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.NotificacaoRequestDto;
import com.odontovision.Java_API.dto.NotificacaoResponseDto;
import com.odontovision.Java_API.entity.Notificacao;
import com.odontovision.Java_API.entity.Usuario;

public final class NotificacaoMapper {

    private NotificacaoMapper() {}

    public static NotificacaoResponseDto toResponseDto(Notificacao e) {
        return new NotificacaoResponseDto(
                e.getId(),
                e.getTitulo(),
                e.getConteudo(),
                e.getDataEnvio(),
                e.getUsuario().getId()
        );
    }

    public static Notificacao toEntity(NotificacaoRequestDto dto, Usuario usuario) {
        Notificacao e = new Notificacao();
        e.setTitulo(dto.titulo());
        e.setConteudo(dto.conteudo());
        e.setDataEnvio(java.time.Instant.now());
        e.setUsuario(usuario);
        return e;
    }
}