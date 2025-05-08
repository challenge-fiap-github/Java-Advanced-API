package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.UsuarioNivelDto;
import com.odontovision.Java_API.entity.UsuarioNivel;
import com.odontovision.Java_API.entity.UsuarioNivelId;
import com.odontovision.Java_API.exception.UsuarioNivelNotFoundException;
import com.odontovision.Java_API.mapper.UsuarioNivelMapper;
import com.odontovision.Java_API.repository.UsuarioNivelRepository;
import com.odontovision.Java_API.repository.NivelRepository;
import com.odontovision.Java_API.service.UsuarioNivelService;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioNivelServiceImpl implements UsuarioNivelService {

    private final UsuarioNivelRepository repo;
    private final UsuarioService usuarioService;
    private final NivelRepository nivelRepo;

    public UsuarioNivelServiceImpl(UsuarioNivelRepository repo,
                                   UsuarioService usuarioService,
                                   NivelRepository nivelRepo) {
        this.repo = repo;
        this.usuarioService = usuarioService;
        this.nivelRepo = nivelRepo;
    }

    @Override
    public List<UsuarioNivelDto> listarTodos() {
        return repo.findAll().stream()
                .map(UsuarioNivelMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioNivelDto buscarPorId(Long usuarioId, Long nivelId) {
        var key = new UsuarioNivelId(usuarioId, nivelId);
        return repo.findById(key)
                .map(UsuarioNivelMapper::toDto)
                .orElseThrow(() -> new UsuarioNivelNotFoundException(usuarioId, nivelId));
    }

    @Override
    public UsuarioNivelDto criar(UsuarioNivelDto dto) {
        var usuario = usuarioService.buscarEntidadePorId(dto.usuarioId());
        var nivel   = nivelRepo.findById(dto.nivelId())
                .orElseThrow(() -> new UsuarioNivelNotFoundException(dto.usuarioId(), dto.nivelId()));

        UsuarioNivel entidade = UsuarioNivelMapper.toEntity(dto, usuario, nivel);
        UsuarioNivel salvo    = repo.save(entidade);
        return UsuarioNivelMapper.toDto(salvo);
    }

    @Override
    public UsuarioNivelDto atualizar(Long usuarioId, Long nivelId, UsuarioNivelDto dto) {
        var key = new UsuarioNivelId(usuarioId, nivelId);
        UsuarioNivel existente = repo.findById(key)
                .orElseThrow(() -> new UsuarioNivelNotFoundException(usuarioId, nivelId));

        // rebind das chaves, caso tenham mudado (normalmente não mudam)
        existente.setPontosAtuais(dto.pontosAtuais());
        existente.setDataUltimaAtualizacao(dto.dataUltimaAtualizacao());

        UsuarioNivel atualizado = repo.save(existente);
        return UsuarioNivelMapper.toDto(atualizado);
    }

}