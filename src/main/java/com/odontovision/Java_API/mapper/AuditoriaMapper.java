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
                a.getEntidade(),
                a.getAcao(),
                null,
                a.getTimestamp(),
                 null,
                null
        );
    }

    public Auditoria toEntity(AuditoriaDto dto) {
        if (dto == null) return null;
        Auditoria a = new Auditoria(
                dto.tabelaAfetada(),
                dto.tipoOperacao(),
                dto.valoresAntigos() + " -> " + dto.valoresNovos()
        );
        return a;
    }
}