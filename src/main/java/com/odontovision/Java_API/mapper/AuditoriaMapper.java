package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.entity.Auditoria;
import com.odontovision.Java_API.dto.AuditoriaDto;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaMapper {

    public AuditoriaDto toDto(Auditoria a) {
        if (a == null) return null;
        return new AuditoriaDto(
                a.getId(),
                a.getTabelaAfetada(),
                a.getTipoOperacao(),
                a.getUsuarioId(),
                a.getDataOperacao(),
                a.getValoresAntigos(),
                a.getValoresNovos()
        );
    }

    public Auditoria toEntity(AuditoriaDto dto) {
        if (dto == null) return null;
        return new Auditoria(
                dto.tabelaAfetada(),
                dto.tipoOperacao(),
                dto.usuarioId(),
                dto.valoresAntigos(),
                dto.valoresNovos()
        );
    }
}
