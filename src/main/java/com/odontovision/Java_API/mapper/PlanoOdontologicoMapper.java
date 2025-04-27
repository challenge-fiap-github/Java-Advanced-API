package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.PlanoOdontologicoRequestDto;
import com.odontovision.Java_API.dto.PlanoOdontologicoResponseDto;
import com.odontovision.Java_API.entity.PlanoOdontologico;

public class PlanoOdontologicoMapper {

    private PlanoOdontologicoMapper() {
        // Construtor privado para impedir instanciamento
    }

    public static PlanoOdontologico toEntity(PlanoOdontologicoRequestDto dto) {
        if (dto == null) {
            return null;
        }
        PlanoOdontologico plano = new PlanoOdontologico();
        plano.setId(dto.getId());
        plano.setNomePlano(dto.getNomePlano());
        plano.setDescricao(dto.getDescricao());
        plano.setPreco(dto.getPreco());
        plano.setValidade(dto.getValidade());
        return plano;
    }

    public static PlanoOdontologicoResponseDto toResponseDto(PlanoOdontologico plano) {
        if (plano == null) {
            return null;
        }
        return new PlanoOdontologicoResponseDto(
                plano.getNomePlano(),
                plano.getDescricao(),
                plano.getPreco(),
                plano.getValidade()
        );
    }

}
