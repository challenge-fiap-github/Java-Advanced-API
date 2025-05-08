package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.PlanoProcedimentoDto;
import com.odontovision.Java_API.entity.PlanoProcedimento;
import com.odontovision.Java_API.entity.PlanoProcedimentoId;
import com.odontovision.Java_API.entity.PlanoOdontologico;
import com.odontovision.Java_API.entity.Procedimento;
import com.odontovision.Java_API.exception.PlanoProcedimentoNotFoundException;
import com.odontovision.Java_API.exception.PlanoOdontologicoNotFoundException;
import com.odontovision.Java_API.exception.ProcedimentoNotFoundException;
import com.odontovision.Java_API.mapper.PlanoProcedimentoMapper;
import com.odontovision.Java_API.repository.PlanoProcedimentoRepository;
import com.odontovision.Java_API.repository.PlanoOdontologicoRepository;
import com.odontovision.Java_API.repository.ProcedimentoRepository;
import com.odontovision.Java_API.service.PlanoProcedimentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PlanoProcedimentoServiceImpl implements PlanoProcedimentoService {

    private final PlanoProcedimentoRepository repo;
    private final PlanoOdontologicoRepository planoRepo;
    private final ProcedimentoRepository procRepo;

    public PlanoProcedimentoServiceImpl(PlanoProcedimentoRepository repo,
                                        PlanoOdontologicoRepository planoRepo,
                                        ProcedimentoRepository procRepo) {
        this.repo = repo;
        this.planoRepo = planoRepo;
        this.procRepo = procRepo;
    }

    @Override
    public List<PlanoProcedimentoDto> listarTodos() {
        return repo.findAll().stream()
                .map(PlanoProcedimentoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public PlanoProcedimentoDto buscarPorId(Long planoId, Long procedimentoId) {
        var key = new PlanoProcedimentoId(planoId, procedimentoId);
        PlanoProcedimento e = repo.findById(key)
                .orElseThrow(() -> new PlanoProcedimentoNotFoundException(planoId, procedimentoId));
        return PlanoProcedimentoMapper.toDto(e);
    }

    @Override
    public PlanoProcedimentoDto criar(PlanoProcedimentoDto dto) {
        PlanoOdontologico plano = planoRepo.findById(dto.planoId())
                .orElseThrow(() -> new PlanoOdontologicoNotFoundException(dto.planoId()));
        Procedimento proc = procRepo.findById(dto.procedimentoId())
                .orElseThrow(() -> new ProcedimentoNotFoundException(dto.procedimentoId()));

        PlanoProcedimento salvo = repo.save(
                PlanoProcedimentoMapper.toEntity(dto, plano, proc)
        );
        return PlanoProcedimentoMapper.toDto(salvo);
    }

    @Override
    public void excluir(Long planoId, Long procedimentoId) {
        var key = new PlanoProcedimentoId(planoId, procedimentoId);
        repo.findById(key)
                .orElseThrow(() -> new PlanoProcedimentoNotFoundException(planoId, procedimentoId));
        repo.deleteById(key);
    }
}