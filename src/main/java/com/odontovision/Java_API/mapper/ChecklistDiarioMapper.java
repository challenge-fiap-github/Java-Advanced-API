package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ChecklistDiarioDto;
import com.odontovision.Java_API.entity.ChecklistDiario;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.Usuario;

public class ChecklistDiarioMapper {

    private ChecklistDiarioMapper() {
        // Impede instanciação
    }

    public static ChecklistDiario toEntity(ChecklistDiarioDto dto) {
        if (dto == null) {
            return null;
        }
        ChecklistDiario entity = new ChecklistDiario();

        // Se você garantir que o DTO sempre vem com o id, senão comente:
        entity.setId(dto.id());

        // monta apenas referência ao usuário (lazy)
        Usuario u = new Usuario();
        u.setId(dto.usuarioId());
        entity.setUsuario(u);

        entity.setData(dto.data());
        entity.setEscovacao(dto.escovacao());
        entity.setFioDental(dto.fioDental());

        // monta apenas referência à consulta de validação, se houver
        if (dto.consultaValidacaoId() != null) {
            Consulta c = new Consulta();
            c.setId(dto.consultaValidacaoId());
            entity.setConsulta(c);
        }

        return entity;
    }

    public static ChecklistDiarioDto toResponseDto(ChecklistDiario entity) {
        if (entity == null) {
            return null;
        }
        Long consultaId = entity.getConsulta() != null
                ? entity.getConsulta().getId()
                : null;

        return new ChecklistDiarioDto(
                entity.getId(),
                entity.getUsuario().getId(),
                entity.getData(),
                entity.getEscovacao(),
                entity.getFioDental(),
                consultaId
        );
    }
}