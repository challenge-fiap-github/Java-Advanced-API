// src/main/java/com/odontovision/Java_API/service/impl/EnderecoUsuarioServiceImpl.java
package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.EnderecoUsuarioDto;
import com.odontovision.Java_API.entity.EnderecoUsuario;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.exception.EnderecoUsuarioNotFoundException;
import com.odontovision.Java_API.service.EnderecoUsuarioService;
import com.odontovision.Java_API.service.UsuarioService;
import com.odontovision.Java_API.repository.EnderecoUsuarioRepository;
import com.odontovision.Java_API.mapper.EnderecoUsuarioMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnderecoUsuarioServiceImpl implements EnderecoUsuarioService {

    private final EnderecoUsuarioRepository repository;
    private final UsuarioService usuarioService;

    public EnderecoUsuarioServiceImpl(EnderecoUsuarioRepository repository,
                                      UsuarioService usuarioService) {
        this.repository = repository;
        this.usuarioService = usuarioService;
    }

    @Override
    public EnderecoUsuarioDto criar(Long usuarioId, EnderecoUsuarioDto dto) {
        // busca entidade Usuário via serviço
        Usuario usuario = usuarioService.buscarEntidadePorId(usuarioId);

        // converte DTO → entidade
        EnderecoUsuario end = EnderecoUsuarioMapper.toEntity(dto);
        end.setUsuario(usuario);

        EnderecoUsuario salvo = repository.save(end);
        return EnderecoUsuarioMapper.toDto(salvo);
    }

    @Override
    public EnderecoUsuarioDto atualizar(Long id, Long usuarioId, EnderecoUsuarioDto dto) {
        EnderecoUsuario existente = repository.findById(id)
                .orElseThrow(() -> new EnderecoUsuarioNotFoundException(id));

        Usuario usuario = usuarioService.buscarEntidadePorId(usuarioId);

        // atualiza campos
        existente.setUsuario(usuario);
        existente.setLogradouro(dto.logradouro());
        existente.setNumero(dto.numero());
        existente.setCidade(dto.cidade());
        existente.setEstado(dto.estado());
        existente.setCep(dto.cep());
        existente.setComplemento(dto.complemento());

        EnderecoUsuario atualizado = repository.save(existente);
        return EnderecoUsuarioMapper.toDto(atualizado);
    }

    @Override
    public void deletar(Long id) {
        EnderecoUsuario existente = repository.findById(id)
                .orElseThrow(() -> new EnderecoUsuarioNotFoundException(id));
        repository.delete(existente);
    }

    @Override
    public EnderecoUsuarioDto buscarPorId(Long id) {
        EnderecoUsuario existente = repository.findById(id)
                .orElseThrow(() -> new EnderecoUsuarioNotFoundException(id));
        return EnderecoUsuarioMapper.toDto(existente);
    }

    @Override
    public List<EnderecoUsuarioDto> listarTodos() {
        return repository.findAll().stream()
                .map(EnderecoUsuarioMapper::toDto)
                .collect(Collectors.toList());
    }
}