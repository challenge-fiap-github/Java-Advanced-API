package com.odontovision.Java_API.service;

import com.odontovision.Java_API.dto.EnderecoClinicaDto;

import java.util.List;

public interface EnderecoClinicaService {

    List<EnderecoClinicaDto> listarTodos();

    EnderecoClinicaDto buscarPorId(Long id);

    EnderecoClinicaDto criar(EnderecoClinicaDto dto);

    EnderecoClinicaDto atualizar(Long id, EnderecoClinicaDto dto);

    void excluir(Long id);
}