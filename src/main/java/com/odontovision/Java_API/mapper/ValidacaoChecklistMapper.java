package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ValidacaoChecklistDto;
import com.odontovision.Java_API.entity.ValidacaoChecklist;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.Consulta;

public final class ValidacaoChecklistMapper {

    private ValidacaoChecklistMapper() {}

    /** Entidade → DTO */
    public static ValidacaoChecklistDto toDto(ValidacaoChecklist e) {
        return new ValidacaoChecklistDto(
                e.getId(),
                e.getUsuario().getId(),
                e.getConsulta().getId(),
                e.getDataValidacao(),
                e.getStatusValidacao(),
                e.getPontosBonus()
        );
    }

    /** DTO + entidades relacionadas → Entidade */
    public static ValidacaoChecklist toEntity(ValidacaoChecklistDto dto,
                                              Usuario usuario,
                                              Consulta consulta) {
        ValidacaoChecklist e = new ValidacaoChecklist();
        e.setUsuario(usuario);
        e.setConsulta(consulta);
        e.setDataValidacao(dto.dataValidacao());
        e.setStatusValidacao(dto.statusValidacao());
        e.setPontosBonus(dto.pontosBonus());
        return e;
    }
}