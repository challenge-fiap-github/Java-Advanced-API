package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.HistoricoPontuacaoDto;
import com.odontovision.Java_API.entity.HistoricoPontuacao;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.exception.HistoricoPontuacaoNotFoundException;
import com.odontovision.Java_API.mapper.HistoricoPontuacaoMapper;
import com.odontovision.Java_API.repository.HistoricoPontuacaoRepository;
import com.odontovision.Java_API.service.HistoricoPontuacaoService;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class HistoricoPontuacaoServiceImpl implements HistoricoPontuacaoService {

    private final HistoricoPontuacaoRepository repository;
    private final UsuarioService usuarioService;

    public HistoricoPontuacaoServiceImpl(HistoricoPontuacaoRepository repository,
                                         UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    @Override
    public List<HistoricoPontuacaoDto> listarTodos() {
        return repository.findAll().stream()
                .map(HistoricoPontuacaoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public HistoricoPontuacaoDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(HistoricoPontuacaoMapper::toDto)
                .orElseThrow(() -> new HistoricoPontuacaoNotFoundException(id));
    }

    @Override
    public HistoricoPontuacaoDto criar(HistoricoPontuacaoDto dto) {
        Usuario u = usuarioService.buscarEntidadePorId(dto.usuarioId());
        HistoricoPontuacao entidade = HistoricoPontuacaoMapper.toEntity(dto, u);
        HistoricoPontuacao salvo = repository.save(entidade);
        // <- aqui basta:
        return HistoricoPontuacaoMapper.toDto(salvo);
    }

    @Override
    public HistoricoPontuacaoDto atualizar(Long id, HistoricoPontuacaoDto dto) {
        HistoricoPontuacao existente = repository.findById(id)
                .orElseThrow(() -> new HistoricoPontuacaoNotFoundException(id));
        Usuario u = usuarioService.buscarEntidadePorId(dto.usuarioId());

        existente.setUsuario(u);
        existente.setDataConsulta(dto.dataConsulta());
        existente.setPontosGanhos(dto.pontosGanhos());
        existente.setPontosTotais(dto.pontosTotais());

        HistoricoPontuacao atualizado = repository.save(existente);
        return HistoricoPontuacaoMapper.toDto(atualizado);
    }

    @Override
    public void excluir(Long id) {
        repository.findById(id)
                .orElseThrow(() -> new HistoricoPontuacaoNotFoundException(id));
        repository.deleteById(id);
    }
}