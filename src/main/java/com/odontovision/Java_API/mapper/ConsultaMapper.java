package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.ConsultaRequestDto;
import com.odontovision.Java_API.dto.ConsultaResponseDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.StatusConsulta;
import com.odontovision.Java_API.entity.TipoConsulta;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.Dentista;

public class ConsultaMapper {

    private ConsultaMapper() {
        // Não permita instanciação
    }

    public static Consulta toEntity(ConsultaRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Consulta c = new Consulta();
        c.setDataHora(dto.getDataHora());

        // monta apenas com o ID para manter link por lazy-loading
        Usuario u = new Usuario();
        u.setId(dto.getUsuarioId());
        c.setUsuario(u);

        Dentista d = new Dentista();
        d.setId(dto.getDentistaId());
        c.setDentista(d);

        StatusConsulta s = new StatusConsulta();
        s.setId(dto.getStatusId());
        c.setStatusConsulta(s);

        TipoConsulta t = new TipoConsulta();
        t.setId(dto.getTipoConsultaId());
        c.setTipoConsulta(t);

        c.setObservacoes(dto.getObservacoes());
        return c;
    }

    public static ConsultaResponseDto toResponseDto(Consulta consulta) {
        if (consulta == null) {
            return null;
        }
        return new ConsultaResponseDto(
                consulta.getId(),
                consulta.getDataHora(),
                consulta.getUsuario().getId(),
                consulta.getDentista().getId(),
                consulta.getStatusConsulta().getId(),
                consulta.getTipoConsulta().getId(),
                consulta.getObservacoes()
        );
    }
}