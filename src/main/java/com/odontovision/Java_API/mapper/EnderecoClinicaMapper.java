package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.EnderecoClinicaDto;
import com.odontovision.Java_API.entity.EnderecoClinica;

public class EnderecoClinicaMapper {

    private EnderecoClinicaMapper() {

    }
    /** Converte Entidade → DTO */
    public static EnderecoClinicaDto toDto(EnderecoClinica e) {
        return new EnderecoClinicaDto(
                e.getId(),
                e.getDentista().getId(),
                e.getLogradouro(),
                e.getNumero(),
                e.getCidade(),
                e.getEstado(),
                e.getCep(),
                e.getComplemento()
        );
    }

    /** Converte DTO → Entidade */
    public static EnderecoClinica toEntity(EnderecoClinicaDto dto) {
        EnderecoClinica e = new EnderecoClinica();
        // se quiser respeitar o id que vier no DTO (útil em update):
        if (dto.id() != null) {
            e.setId(dto.id());
        }
        e.setLogradouro(dto.logradouro());
        e.setNumero(dto.numero());
        e.setCidade(dto.cidade());
        e.setEstado(dto.estado());
        e.setCep(dto.cep());
        e.setComplemento(dto.complemento());
        // o dentista será atribuído no Service
        return e;
    }
}