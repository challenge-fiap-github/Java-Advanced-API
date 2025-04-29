package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.ChecklistDiarioDto;
import com.odontovision.Java_API.entity.ChecklistDiario;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.ChecklistDiarioMapper;
import com.odontovision.Java_API.repository.ChecklistDiarioRepository;
import com.odontovision.Java_API.service.ChecklistDiarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ChecklistDiarioServiceImpl implements ChecklistDiarioService {

    private final ChecklistDiarioRepository checklistRepository;

    public ChecklistDiarioServiceImpl(ChecklistDiarioRepository checklistRepository) {
        this.checklistRepository = checklistRepository;
    }

    @Override
    public ChecklistDiarioDto criarChecklist(ChecklistDiarioDto dto) {
        ChecklistDiario entity = ChecklistDiarioMapper.toEntity(dto);
        ChecklistDiario salvo = checklistRepository.save(entity);
        return ChecklistDiarioMapper.toResponseDto(salvo);
    }

    @Override
    public ChecklistDiarioDto atualizarChecklist(Long id, ChecklistDiarioDto dto) {
        ChecklistDiario existente = checklistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Checklist não encontrado com ID: " + id));

        // Atualiza a associação de usuário
        Usuario u = new Usuario();
        u.setId(dto.usuarioId());
        existente.setUsuario(u);

        existente.setData(dto.data());
        existente.setEscovacao(dto.escovacao());
        existente.setFioDental(dto.fioDental());

        // Atualiza a associação de consulta de validação (pode ser nulo)
        if (dto.consultaValidacaoId() != null) {
            Consulta c = new Consulta();
            c.setId(dto.consultaValidacaoId());
            existente.setConsulta(c);
        } else {
            existente.setConsulta(null);
        }

        ChecklistDiario atualizado = checklistRepository.save(existente);
        return ChecklistDiarioMapper.toResponseDto(atualizado);
    }

    @Override
    public void deletarChecklist(Long id) {
        ChecklistDiario checklist = checklistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Checklist não encontrado com ID: " + id));
        checklistRepository.delete(checklist);
    }

    @Override
    public ChecklistDiarioDto buscarPorId(Long id) {
        ChecklistDiario checklist = checklistRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Checklist não encontrado com ID: " + id));
        return ChecklistDiarioMapper.toResponseDto(checklist);
    }

    @Override
    public List<ChecklistDiarioDto> listarTodos() {
        return checklistRepository.findAll()
                .stream()
                .map(ChecklistDiarioMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}