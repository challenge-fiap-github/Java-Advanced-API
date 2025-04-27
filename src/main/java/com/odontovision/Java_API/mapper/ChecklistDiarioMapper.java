package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ChecklistDiarioDto;
import com.odontovision.Java_API.entity.ChecklistDiario;

public class ChecklistDiarioMapper {

    private ChecklistDiarioMapper() {
        // Construtor privado para não permitir instanciar
    }

    public static ChecklistDiario toEntity(ChecklistDiarioDto dto) {
        if (dto == null) {
            return null;
        }
        ChecklistDiario checklist = new ChecklistDiario();
        checklist.setId(dto.id());
        checklist.setUsuarioId(dto.usuarioId());
        checklist.setData(dto.data());
        checklist.setEscovacao(dto.escovacao());
        checklist.setFioDental(dto.fioDental());
        checklist.setConsultaValidacaoId(dto.consultaValidacaoId());
        return checklist;
    }

    public static ChecklistDiarioDto toResponseDto(ChecklistDiario checklist) {
        if (checklist == null) {
            return null;
        }
        return new ChecklistDiarioDto(
                checklist.getId(),
                checklist.getUsuarioId(),
                checklist.getData(),
                checklist.getEscovacao(),
                checklist.getFioDental(),
                checklist.getConsultaValidacaoId()
        );
    }
}
