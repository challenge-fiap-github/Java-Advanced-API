package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.NotificacaoRequestDto;
import com.odontovision.Java_API.dto.NotificacaoResponseDto;
import com.odontovision.Java_API.entity.Notificacao;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.exception.NotificacaoNotFoundException;
import com.odontovision.Java_API.mapper.NotificacaoMapper;
import com.odontovision.Java_API.repository.NotificacaoRepository;
import com.odontovision.Java_API.service.NotificacaoService;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class NotificacaoServiceImpl implements NotificacaoService {

    private final NotificacaoRepository repo;
    private final UsuarioService usuarioService;

    public NotificacaoServiceImpl(NotificacaoRepository repo,
                                  UsuarioService usuarioService) {
        this.repo = repo;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<NotificacaoResponseDto> listarTodas() {
        return repo.findAll().stream()
                .map(NotificacaoMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public NotificacaoResponseDto buscarPorId(Long id) {
        return repo.findById(id)
                .map(NotificacaoMapper::toResponseDto)
                .orElseThrow(() -> new NotificacaoNotFoundException(id));
    }

    @Override
    public NotificacaoResponseDto criar(NotificacaoRequestDto dto) {
        Usuario u = usuarioService.buscarEntidadePorId(dto.usuarioId());
        Notificacao e = NotificacaoMapper.toEntity(dto, u);
        Notificacao salvo = repo.save(e);
        return NotificacaoMapper.toResponseDto(salvo);
    }

    @Override
    public NotificacaoResponseDto atualizar(Long id, NotificacaoRequestDto dto) {
        Notificacao existente = repo.findById(id)
                .orElseThrow(() -> new NotificacaoNotFoundException(id));
        Usuario u = usuarioService.buscarEntidadePorId(dto.usuarioId());

        existente.setTitulo(dto.titulo());
        existente.setConteudo(dto.conteudo());
        // não altera dataEnvio
        existente.setUsuario(u);

        Notificacao atualizado = repo.save(existente);
        return NotificacaoMapper.toResponseDto(atualizado);
    }

    @Override
    public void excluir(Long id) {
        Notificacao existente = repo.findById(id)
                .orElseThrow(() -> new NotificacaoNotFoundException(id));
        repo.delete(existente);
    }
}