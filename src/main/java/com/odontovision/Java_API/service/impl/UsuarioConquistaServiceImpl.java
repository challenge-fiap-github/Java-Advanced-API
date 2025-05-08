package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.UsuarioConquistaDto;
import com.odontovision.Java_API.entity.UsuarioConquista;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.Conquista;
import com.odontovision.Java_API.entity.UsuarioConquistaId;
import com.odontovision.Java_API.exception.UsuarioConquistaNotFoundException;
import com.odontovision.Java_API.mapper.UsuarioConquistaMapper;
import com.odontovision.Java_API.repository.UsuarioConquistaRepository;
import com.odontovision.Java_API.repository.ConquistaRepository;
import com.odontovision.Java_API.service.UsuarioConquistaService;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioConquistaServiceImpl implements UsuarioConquistaService {

    private final UsuarioConquistaRepository repository;
    private final UsuarioService usuarioService;
    private final ConquistaRepository conquistaRepo;

    public UsuarioConquistaServiceImpl(UsuarioConquistaRepository repository,
                                       UsuarioService usuarioService,
                                       ConquistaRepository conquistaRepo) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.conquistaRepo = conquistaRepo;
    }

    @Override
    public List<UsuarioConquistaDto> listarTodos() {
        return repository.findAll().stream()
                .map(UsuarioConquistaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioConquistaDto buscarPorId(Long usuarioId, Long conquistaId) {
        var key = new UsuarioConquistaId(usuarioId, conquistaId);
        return repository.findById(key)
                .map(UsuarioConquistaMapper::toDto)
                .orElseThrow(() -> new UsuarioConquistaNotFoundException(usuarioId, conquistaId));
    }

    @Override
    public UsuarioConquistaDto criar(UsuarioConquistaDto dto) {
        Usuario usuario = usuarioService.buscarEntidadePorId(dto.usuarioId());
        Conquista conquista = conquistaRepo.findById(dto.conquistaId())
                .orElseThrow(() -> new UsuarioConquistaNotFoundException(dto.usuarioId(), dto.conquistaId()));

        UsuarioConquista entidade = UsuarioConquistaMapper.toEntity(dto, usuario, conquista);
        UsuarioConquista salvo = repository.save(entidade);
        // aqui chama direto o toDto, sem method reference
        return UsuarioConquistaMapper.toDto(salvo);
    }

    @Override
    public UsuarioConquistaDto atualizar(Long usuarioId, Long conquistaId, UsuarioConquistaDto dto) {
        var key = new UsuarioConquistaId(usuarioId, conquistaId);
        UsuarioConquista existente = repository.findById(key)
                .orElseThrow(() -> new UsuarioConquistaNotFoundException(usuarioId, conquistaId));

        Usuario usuario = usuarioService.buscarEntidadePorId(dto.usuarioId());
        Conquista conquista = conquistaRepo.findById(dto.conquistaId())
                .orElseThrow(() -> new UsuarioConquistaNotFoundException(dto.usuarioId(), dto.conquistaId()));

        existente.setUsuario(usuario);
        existente.setConquista(conquista);
        existente.setDataObtencao(dto.dataObtencao());

        UsuarioConquista atualizado = repository.save(existente);
        return UsuarioConquistaMapper.toDto(atualizado);
    }

}