package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ProcedimentoRequestDto;
import com.odontovision.Java_API.dto.ProcedimentoResponseDto;
import com.odontovision.Java_API.entity.Procedimento;

public final class ProcedimentoMapper {

    private ProcedimentoMapper() {}

    public static ProcedimentoResponseDto toDto(Procedimento entidade) {
        return new ProcedimentoResponseDto(
                entidade.getId(),
                entidade.getNomeProcedimento(),
                entidade.getDescricao(),
                entidade.getCusto()
        );
    }

    public static Procedimento toEntity(ProcedimentoRequestDto dto) {
        Procedimento p = new Procedimento();
        p.setNomeProcedimento(dto.getNomeProcedimento());
        p.setDescricao(dto.getDescricao());
        p.setCusto(dto.getCusto());
        return p;
    }
}