package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.ValidacaoChecklistDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.ValidacaoChecklist;
import com.odontovision.Java_API.exception.ValidacaoChecklistNotFoundException;
import com.odontovision.Java_API.mapper.ValidacaoChecklistMapper;
import com.odontovision.Java_API.repository.ValidacaoChecklistRepository;
import com.odontovision.Java_API.service.ConsultaService;
import com.odontovision.Java_API.service.UsuarioService;
import com.odontovision.Java_API.service.ValidacaoChecklistService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ValidacaoChecklistServiceImpl implements ValidacaoChecklistService {

    private final ValidacaoChecklistRepository repository;
    private final UsuarioService usuarioService;
    private final ConsultaService consultaService;

    public ValidacaoChecklistServiceImpl(ValidacaoChecklistRepository repository,
                                         UsuarioService usuarioService,
                                         ConsultaService consultaService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.consultaService = consultaService;
    }

    @Override
    public List<ValidacaoChecklistDto> listarTodos() {
        return repository.findAll().stream()
                .map(ValidacaoChecklistMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ValidacaoChecklistDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(ValidacaoChecklistMapper::toDto)
                .orElseThrow(() -> new ValidacaoChecklistNotFoundException(id));
    }

    @Override
    public ValidacaoChecklistDto criar(ValidacaoChecklistDto dto) {
        Usuario usuario = usuarioService.buscarEntidadePorId(dto.usuarioId());
        Consulta consulta = consultaService.buscarEntidadePorId(dto.consultaId());

        ValidacaoChecklist entidade = ValidacaoChecklistMapper.toEntity(dto, usuario, consulta);
        ValidacaoChecklist salvo = repository.save(entidade);
        return ValidacaoChecklistMapper.toDto(salvo);
    }

    @Override
    public ValidacaoChecklistDto atualizar(Long id, ValidacaoChecklistDto dto) {
        ValidacaoChecklist existente = repository.findById(id)
                .orElseThrow(() -> new ValidacaoChecklistNotFoundException(id));

        Usuario usuario = usuarioService.buscarEntidadePorId(dto.usuarioId());
        Consulta consulta = consultaService.buscarEntidadePorId(dto.consultaId());

        existente.setUsuario(usuario);
        existente.setConsulta(consulta);
        existente.setDataValidacao(dto.dataValidacao());
        existente.setStatusValidacao(dto.statusValidacao());
        existente.setPontosBonus(dto.pontosBonus());

        ValidacaoChecklist atualizado = repository.save(existente);
        return ValidacaoChecklistMapper.toDto(atualizado);
    }

    @Override
    public void deletar(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new ValidacaoChecklistNotFoundException(id));
        repository.deleteById(id);
    }
}