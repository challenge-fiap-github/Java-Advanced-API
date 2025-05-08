package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.ConsultaProcedimentoDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.ConsultaProcedimento;
import com.odontovision.Java_API.entity.ConsultaProcedimentoId;
import com.odontovision.Java_API.entity.Procedimento;
import com.odontovision.Java_API.exception.ConsultaProcedimentoNotFoundException;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.ConsultaProcedimentoMapper;
import com.odontovision.Java_API.repository.ConsultaProcedimentoRepository;
import com.odontovision.Java_API.repository.ConsultaRepository;
import com.odontovision.Java_API.repository.ProcedimentoRepository;
import com.odontovision.Java_API.service.ConsultaProcedimentoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConsultaProcedimentoServiceImpl implements ConsultaProcedimentoService {

    private final ConsultaProcedimentoRepository repository;
    private final ConsultaRepository consultaRepo;
    private final ProcedimentoRepository procRepo;

    public ConsultaProcedimentoServiceImpl(
            ConsultaProcedimentoRepository repository,
            ConsultaRepository consultaRepo,
            ProcedimentoRepository procRepo
    ) {
        this.repository = repository;
        this.consultaRepo = consultaRepo;
        this.procRepo = procRepo;
    }

    @Override
    public List<ConsultaProcedimentoDto> listarTodos() {
        return repository.findAll().stream()
                .map(ConsultaProcedimentoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultaProcedimentoDto buscarPorId(Long cid, Long pid) {
        var key = new ConsultaProcedimentoId(cid, pid);
        return repository.findById(key)
                .map(ConsultaProcedimentoMapper::toDto)
                .orElseThrow(() -> new ConsultaProcedimentoNotFoundException(cid, pid));
    }

    @Override
    public ConsultaProcedimentoDto criar(ConsultaProcedimentoDto dto) {
        Consulta consulta = consultaRepo.findById(dto.consultaId())
                .orElseThrow(() -> new ResourceNotFoundException("Consulta", dto.consultaId()));
        Procedimento proc = procRepo.findById(dto.procedimentoId())
                .orElseThrow(() -> new ResourceNotFoundException("Procedimento", dto.procedimentoId()));

        ConsultaProcedimento cp = ConsultaProcedimentoMapper.toEntity(dto, consulta, proc);
        ConsultaProcedimento salvo = repository.save(cp);
        return ConsultaProcedimentoMapper.toDto(salvo);
    }

}