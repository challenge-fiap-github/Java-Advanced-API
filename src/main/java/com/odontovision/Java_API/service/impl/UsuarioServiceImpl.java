package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.UsuarioRequestDTO;
import com.odontovision.Java_API.dto.UsuarioResponseDto;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.UsuarioMapper;
import com.odontovision.Java_API.repository.UsuarioRepository;
import com.odontovision.Java_API.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioResponseDto criarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuario = UsuarioMapper.toEntity(usuarioRequestDTO);
        Usuario salvo = usuarioRepository.save(usuario);
        return UsuarioMapper.toResponseDto(salvo);
    }

    @Override
    public UsuarioResponseDto atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));

        usuarioExistente.setNome(usuarioRequestDTO.getNome());
        usuarioExistente.setEmail(usuarioRequestDTO.getEmail());
        usuarioExistente.setSenha(usuarioRequestDTO.getSenha());
        usuarioExistente.setDataNascimento(usuarioRequestDTO.getDataNascimento());
        usuarioExistente.setCpf(usuarioRequestDTO.getCpf());
        usuarioExistente.setTelefone(usuarioRequestDTO.getTelefone());

        Usuario atualizado = usuarioRepository.save(usuarioExistente);
        return UsuarioMapper.toResponseDto(atualizado);
    }

    @Override
    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        usuarioRepository.delete(usuario);
    }

    @Override
    public UsuarioResponseDto buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + id));
        return UsuarioMapper.toResponseDto(usuario);
    }

    @Override
    public List<UsuarioResponseDto> listarTodos() {
        return usuarioRepository.findAll()
                .stream()
                .map(UsuarioMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
