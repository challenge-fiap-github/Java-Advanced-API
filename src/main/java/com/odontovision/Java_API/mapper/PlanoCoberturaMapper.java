package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.PlanoCoberturaDto;
import com.odontovision.Java_API.entity.PlanoCobertura;
import com.odontovision.Java_API.entity.PlanoOdontologico;

public final class PlanoCoberturaMapper {

    private PlanoCoberturaMapper() { /* evitar instanciação */ }

    public static PlanoCoberturaDto toDto(PlanoCobertura e) {
        return new PlanoCoberturaDto(
                e.getId(),
                e.getPlano().getId(),
                e.getDescricao()
        );
    }

    public static PlanoCobertura toEntity(PlanoCoberturaDto dto,
                                          PlanoOdontologico plano) {
        PlanoCobertura e = new PlanoCobertura();
        e.setPlano(plano);
        e.setDescricao(dto.descricao());
        return e;
    }
}