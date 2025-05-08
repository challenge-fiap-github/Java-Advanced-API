package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.HistoricoPontuacaoDto;
import com.odontovision.Java_API.entity.HistoricoPontuacao;
import com.odontovision.Java_API.entity.Usuario;

public class HistoricoPontuacaoMapper {

    private HistoricoPontuacaoMapper() {
        // evitar instanciação
    }

    /** Entidade → DTO */
    public static HistoricoPontuacaoDto toDto(HistoricoPontuacao e) {
        return new HistoricoPontuacaoDto(
                e.getId(),
                e.getUsuario().getId(),
                e.getDataConsulta(),
                e.getPontosGanhos(),
                e.getPontosTotais()
        );
    }

    /** DTO + entidade Usuário → Entidade */
    public static HistoricoPontuacao toEntity(HistoricoPontuacaoDto dto, Usuario usuario) {
        HistoricoPontuacao e = new HistoricoPontuacao();
        // não há setter de ID (PK gerada pelo BD)
        e.setUsuario(usuario);
        e.setDataConsulta(dto.dataConsulta());
        e.setPontosGanhos(dto.pontosGanhos());
        e.setPontosTotais(dto.pontosTotais());
        return e;
    }
}