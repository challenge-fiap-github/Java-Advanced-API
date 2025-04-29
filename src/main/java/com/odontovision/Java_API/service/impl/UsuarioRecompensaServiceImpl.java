package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.UsuarioRecompensaDto;
import com.odontovision.Java_API.entity.Recompensa;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.entity.UsuarioRecompensa;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.repository.RecompensaRepository;
import com.odontovision.Java_API.repository.UsuarioRecompensaRepository;
import com.odontovision.Java_API.repository.UsuarioRepository;
import com.odontovision.Java_API.service.UsuarioRecompensaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioRecompensaServiceImpl implements UsuarioRecompensaService {

    private final UsuarioRecompensaRepository usuarioRecompensaRepository;
    private final RecompensaRepository recompensaRepository;
    private final UsuarioRepository usuarioRepository;

    public UsuarioRecompensaServiceImpl(UsuarioRecompensaRepository usuarioRecompensaRepository,
                                        RecompensaRepository recompensaRepository,
                                        UsuarioRepository usuarioRepository) {
        this.usuarioRecompensaRepository = usuarioRecompensaRepository;
        this.recompensaRepository = recompensaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UsuarioRecompensaDto criarUsuarioRecompensa(UsuarioRecompensaDto dto) {
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

        Recompensa recompensa = recompensaRepository.findById(dto.recompensaId())
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa não encontrada"));

        var ur = new UsuarioRecompensa();
        ur.setUsuario(usuario);
        ur.setRecompensa(recompensa);
        ur.setDataResgate(dto.dataResgate());

        var salvo = usuarioRecompensaRepository.save(ur);
        return new UsuarioRecompensaDto(
                salvo.getId(),
                salvo.getUsuario().getId(),
                salvo.getRecompensa().getId(),
                salvo.getDataResgate()
        );
    }

    @Override
    public void deletarUsuarioRecompensa(Long id) {
        var ent = usuarioRecompensaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UsuárioRecompensa não encontrado: " + id));
        usuarioRecompensaRepository.delete(ent);
    }

    @Override
    public UsuarioRecompensaDto buscarPorId(Long id) {
        var ent = usuarioRecompensaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UsuárioRecompensa não encontrado: " + id));
        return toDto(ent);
    }

    @Override
    public List<UsuarioRecompensaDto> listarTodos() {
        return usuarioRecompensaRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();  // Java 16+: .toList() em vez de .collect(Collectors.toList())
    }

    private UsuarioRecompensaDto toDto(UsuarioRecompensa ent) {
        return new UsuarioRecompensaDto(
                ent.getId(),
                ent.getUsuario().getId(),
                ent.getRecompensa().getId(),
                ent.getDataResgate()
        );
    }
}