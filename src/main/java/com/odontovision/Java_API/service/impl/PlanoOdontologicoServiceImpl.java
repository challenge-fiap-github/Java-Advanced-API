package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.PlanoOdontologicoRequestDto;
import com.odontovision.Java_API.dto.PlanoOdontologicoResponseDto;
import com.odontovision.Java_API.entity.PlanoOdontologico;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.PlanoOdontologicoMapper;
import com.odontovision.Java_API.repository.PlanoOdontologicoRepository;
import com.odontovision.Java_API.service.PlanoOdontologicoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanoOdontologicoServiceImpl implements PlanoOdontologicoService {

    private final PlanoOdontologicoRepository planoRepository;

    public PlanoOdontologicoServiceImpl(PlanoOdontologicoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    @Override
    public PlanoOdontologicoResponseDto criarPlano(PlanoOdontologicoRequestDto dto) {
        PlanoOdontologico plano = PlanoOdontologicoMapper.toEntity(dto);
        PlanoOdontologico salvo = planoRepository.save(plano);
        return PlanoOdontologicoMapper.toResponseDto(salvo);
    }

    @Override
    public PlanoOdontologicoResponseDto atualizarPlano(Long id, PlanoOdontologicoRequestDto dto) {
        PlanoOdontologico existente = planoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com ID: " + id));

        existente.setNomePlano(dto.getNomePlano());
        existente.setDescricao(dto.getDescricao());
        existente.setPreco(dto.getPreco());
        existente.setValidade(dto.getValidade());

        PlanoOdontologico atualizado = planoRepository.save(existente);
        return PlanoOdontologicoMapper.toResponseDto(atualizado);
    }

    @Override
    public void deletarPlano(Long id) {
        PlanoOdontologico plano = planoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com ID: " + id));
        planoRepository.delete(plano);
    }

    @Override
    public PlanoOdontologicoResponseDto buscarPorId(Long id) {
        PlanoOdontologico plano = planoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plano não encontrado com ID: " + id));
        return PlanoOdontologicoMapper.toResponseDto(plano);
    }

    @Override
    public List<PlanoOdontologicoResponseDto> listarTodos() {
        return planoRepository.findAll()
                .stream()
                .map(PlanoOdontologicoMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
