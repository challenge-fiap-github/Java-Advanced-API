package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.UsuarioPlanoDto;
import com.odontovision.Java_API.entity.UsuarioPlano;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.PlanoOdontologico;
import com.odontovision.Java_API.exception.UsuarioPlanoNotFoundException;
import com.odontovision.Java_API.mapper.UsuarioPlanoMapper;
import com.odontovision.Java_API.repository.UsuarioPlanoRepository;
import com.odontovision.Java_API.repository.PlanoOdontologicoRepository;
import com.odontovision.Java_API.service.UsuarioPlanoService;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioPlanoServiceImpl implements UsuarioPlanoService {

    private final UsuarioPlanoRepository repository;
    private final UsuarioService usuarioService;
    private final PlanoOdontologicoRepository planoRepo;

    public UsuarioPlanoServiceImpl(UsuarioPlanoRepository repository,
                                   UsuarioService usuarioService,
                                   PlanoOdontologicoRepository planoRepo) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.planoRepo = planoRepo;
    }

    @Override
    public List<UsuarioPlanoDto> listarTodos() {
        return repository.findAll().stream()
                .map(UsuarioPlanoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioPlanoDto buscarPorId(Long id) {
        return repository.findById(id)
                .map(UsuarioPlanoMapper::toDto)
                .orElseThrow(() -> new UsuarioPlanoNotFoundException(id));
    }

    @Override
    public UsuarioPlanoDto criar(UsuarioPlanoDto dto) {
        Usuario usuario = usuarioService.buscarEntidadePorId(dto.getUsuarioId());
        PlanoOdontologico plano = planoRepo.findById(dto.getPlanoId())
                .orElseThrow(() -> new UsuarioPlanoNotFoundException(dto.getId()));
        UsuarioPlano entidade = UsuarioPlanoMapper.toEntity(dto, usuario, plano);
        UsuarioPlano salvo = repository.save(entidade);
        return UsuarioPlanoMapper.toDto(salvo);
    }

    @Override
    public UsuarioPlanoDto atualizar(Long id, UsuarioPlanoDto dto) {
        UsuarioPlano existente = repository.findById(id)
                .orElseThrow(() -> new UsuarioPlanoNotFoundException(id));

        Usuario usuario = usuarioService.buscarEntidadePorId(dto.getUsuarioId());
        PlanoOdontologico plano = planoRepo.findById(dto.getPlanoId())
                .orElseThrow(() -> new UsuarioPlanoNotFoundException(id));

        existente.setUsuario(usuario);
        existente.setPlano(plano);
        existente.setDataAdesao(dto.getDataAdesao());

        UsuarioPlano atualizado = repository.save(existente);
        return UsuarioPlanoMapper.toDto(atualizado);
    }

}