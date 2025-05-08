package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.PlanoProcedimentoDto;
import com.odontovision.Java_API.entity.PlanoProcedimento;
import com.odontovision.Java_API.entity.PlanoProcedimentoId;
import com.odontovision.Java_API.entity.PlanoOdontologico;
import com.odontovision.Java_API.entity.Procedimento;

public final class PlanoProcedimentoMapper {

    private PlanoProcedimentoMapper() {}

    public static PlanoProcedimentoDto toDto(PlanoProcedimento e) {
        return new PlanoProcedimentoDto(
                e.getPlano().getId(),
                e.getProcedimento().getId()
        );
    }

    public static PlanoProcedimento toEntity(PlanoProcedimentoDto dto,
                                             PlanoOdontologico plano,
                                             Procedimento procedimento) {
        PlanoProcedimento pc = new PlanoProcedimento();
        pc.setId(new PlanoProcedimentoId(dto.planoId(), dto.procedimentoId()));
        pc.setPlano(plano);
        pc.setProcedimento(procedimento);
        return pc;
    }
}