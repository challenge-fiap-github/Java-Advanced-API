package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.SinistroRequestDto;
import com.odontovision.Java_API.dto.SinistroResponseDto;
import com.odontovision.Java_API.entity.Sinistro;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.Procedimento;

public final class SinistroMapper {

    private SinistroMapper() {}

    public static SinistroResponseDto toResponseDto(Sinistro s) {
        return new SinistroResponseDto(
                s.getId(),
                s.getPaciente().getId(),
                s.getProcedimento().getId(),
                s.getDataSinistro(),
                s.getRiscoFraude(),
                s.getDescricaoRisco()
        );
    }

    public static Sinistro toEntity(
            SinistroRequestDto dto,
            Usuario paciente,
            Procedimento procedimento
    ) {
        Sinistro s = new Sinistro();
        s.setPaciente(paciente);
        s.setProcedimento(procedimento);
        s.setDataSinistro(dto.dataSinistro());
        s.setRiscoFraude(dto.riscoFraude());
        s.setDescricaoRisco(dto.descricaoRisco());
        return s;
    }
}