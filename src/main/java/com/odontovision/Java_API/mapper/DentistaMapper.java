package com.odontovision.Java_API.mapper;

import com.odontovision.Java_API.dto.DentistaRequestDto;
import com.odontovision.Java_API.dto.DentistaResponseDto;
import com.odontovision.Java_API.entity.Dentista;
import org.springframework.stereotype.Component;

@Component
public class DentistaMapper {

    public Dentista toEntity(DentistaRequestDto dto) {
        Dentista d = new Dentista();
        if (dto.getId() != null) {
            d.setId(dto.getId());
        }
        d.setNome(dto.getNome());
        d.setCro(dto.getCro());
        d.setEspecialidade(dto.getEspecialidade());
        d.setTelefone(dto.getTelefone());
        d.setEmail(dto.getEmail());
        return d;
    }

    public DentistaResponseDto toResponseDto(Dentista d) {
        return new DentistaResponseDto(
                d.getId(),
                d.getNome(),
                d.getCro(),
                d.getEspecialidade(),
                d.getTelefone(),
                d.getEmail()
        );
    }
}