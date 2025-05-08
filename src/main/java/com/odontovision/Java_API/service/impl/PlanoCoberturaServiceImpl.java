package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.PlanoCoberturaDto;
import com.odontovision.Java_API.entity.PlanoCobertura;
import com.odontovision.Java_API.entity.PlanoOdontologico;
import com.odontovision.Java_API.exception.PlanoCoberturaNotFoundException;
import com.odontovision.Java_API.exception.PlanoOdontologicoNotFoundException;
import com.odontovision.Java_API.mapper.PlanoCoberturaMapper;
import com.odontovision.Java_API.repository.PlanoCoberturaRepository;
import com.odontovision.Java_API.repository.PlanoOdontologicoRepository;
import com.odontovision.Java_API.service.PlanoCoberturaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanoCoberturaServiceImpl implements PlanoCoberturaService {

    private final PlanoCoberturaRepository repo;
    private final PlanoOdontologicoRepository planoRepo;

    public PlanoCoberturaServiceImpl(PlanoCoberturaRepository repo,
                                     PlanoOdontologicoRepository planoRepo) {
        this.repo = repo;
        this.planoRepo = planoRepo;
    }

    @Override
    public List<PlanoCoberturaDto> listarTodos() {
        return repo.findAll().stream()
                .map(PlanoCoberturaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlanoCoberturaDto buscarPorId(Long id) {
        PlanoCobertura e = repo.findById(id)
                .orElseThrow(() -> new PlanoCoberturaNotFoundException(id));
        return PlanoCoberturaMapper.toDto(e);
    }

    @Override
    public PlanoCoberturaDto criar(PlanoCoberturaDto dto) {
        PlanoOdontologico plano = planoRepo.findById(dto.planoId())
                .orElseThrow(() -> new PlanoOdontologicoNotFoundException(dto.planoId()));
        PlanoCobertura e = PlanoCoberturaMapper.toEntity(dto, plano);
        PlanoCobertura salvo = repo.save(e);
        return PlanoCoberturaMapper.toDto(salvo);
    }

    @Override
    public PlanoCoberturaDto atualizar(Long id, PlanoCoberturaDto dto) {
        PlanoCobertura existente = repo.findById(id)
                .orElseThrow(() -> new PlanoCoberturaNotFoundException(id));

        if (!existente.getPlano().getId().equals(dto.planoId())) {
            PlanoOdontologico novo = planoRepo.findById(dto.planoId())
                    .orElseThrow(() -> new PlanoOdontologicoNotFoundException(dto.planoId()));
            existente.setPlano(novo);
        }
        existente.setDescricao(dto.descricao());

        PlanoCobertura atualizado = repo.save(existente);
        return PlanoCoberturaMapper.toDto(atualizado);
    }

    @Override
    public void excluir(Long id) {
        repo.findById(id)
                .orElseThrow(() -> new PlanoCoberturaNotFoundException(id));
        repo.deleteById(id);
    }
}