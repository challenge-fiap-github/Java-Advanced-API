package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.HistoricoTratamentoDto;
import com.odontovision.Java_API.entity.Dentista;
import com.odontovision.Java_API.entity.HistoricoTratamento;
import com.odontovision.Java_API.entity.Procedimento;
import com.odontovision.Java_API.entity.Usuario;

public final class HistoricoTratamentoMapper {

    private HistoricoTratamentoMapper() {}

    /** Entidade → DTO */
    public static HistoricoTratamentoDto toDto(HistoricoTratamento e) {
        return new HistoricoTratamentoDto(
                e.getId(),
                e.getUsuario().getId(),
                e.getProcedimento().getId(),
                e.getDentista().getId(),
                e.getData(),
                e.getObservacoes()
        );
    }

    /** DTO + entidades relacionadas → Entidade */
    public static HistoricoTratamento toEntity(HistoricoTratamentoDto dto,
                                               Usuario usuario,
                                               Procedimento procedimento,
                                               Dentista dentista) {
        return new HistoricoTratamento(
                usuario,
                procedimento,
                dentista,
                dto.data(),
                dto.observacoes()
        );
    }
}