package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ConsultaProcedimentoDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.ConsultaProcedimento;
import com.odontovision.Java_API.entity.ConsultaProcedimentoId;
import com.odontovision.Java_API.entity.Procedimento;

public final class ConsultaProcedimentoMapper {

    private ConsultaProcedimentoMapper() {}

    /** Entidade → DTO */
    public static ConsultaProcedimentoDto toDto(ConsultaProcedimento cp) {
        return new ConsultaProcedimentoDto(
                cp.getConsulta().getId(),
                cp.getProcedimento().getId()
        );
    }

    /** DTO + entidades relacionadas → Entidade */
    public static ConsultaProcedimento toEntity(
            ConsultaProcedimentoDto dto,
            Consulta consulta,
            Procedimento procedimento) {
        ConsultaProcedimento cp = new ConsultaProcedimento();
        cp.setId(new ConsultaProcedimentoId(dto.consultaId(), dto.procedimentoId()));
        cp.setConsulta(consulta);
        cp.setProcedimento(procedimento);
        return cp;
    }
}