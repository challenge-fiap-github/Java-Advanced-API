package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.UsuarioRecompensaDto;
import com.odontovision.Java_API.entity.Recompensa;
import com.odontovision.Java_API.entity.UsuarioRecompensa;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.repository.RecompensaRepository;
import com.odontovision.Java_API.repository.UsuarioRecompensaRepository;
import com.odontovision.Java_API.service.UsuarioRecompensaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsuarioRecompensaServiceImpl implements UsuarioRecompensaService {

    private final UsuarioRecompensaRepository usuarioRecompensaRepository;
    private final RecompensaRepository recompensaRepository;

    public UsuarioRecompensaServiceImpl(UsuarioRecompensaRepository usuarioRecompensaRepository, RecompensaRepository recompensaRepository) {
        this.usuarioRecompensaRepository = usuarioRecompensaRepository;
        this.recompensaRepository = recompensaRepository;
    }

    @Override
    public UsuarioRecompensaDto criarUsuarioRecompensa(UsuarioRecompensaDto dto) {
        Recompensa recompensa = recompensaRepository.findById(dto.recompensaId())
                .orElseThrow(() -> new ResourceNotFoundException("Recompensa não encontrada"));

        UsuarioRecompensa usuarioRecompensa = new UsuarioRecompensa();
        usuarioRecompensa.setUsuarioId(dto.usuarioId());
        usuarioRecompensa.setRecompensa(recompensa);
        usuarioRecompensa.setDataResgate(dto.dataResgate());

        UsuarioRecompensa salvo = usuarioRecompensaRepository.save(usuarioRecompensa);
        return new UsuarioRecompensaDto(salvo.getId(), salvo.getUsuarioId(), salvo.getRecompensa().getId(), salvo.getDataResgate());
    }

    @Override
    public void deletarUsuarioRecompensa(Long id) {
        UsuarioRecompensa entity = usuarioRecompensaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário Recompensa não encontrado com ID: " + id));
        usuarioRecompensaRepository.delete(entity);
    }

    @Override
    public UsuarioRecompensaDto buscarPorId(Long id) {
        UsuarioRecompensa entity = usuarioRecompensaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário Recompensa não encontrado com ID: " + id));
        return new UsuarioRecompensaDto(entity.getId(), entity.getUsuarioId(), entity.getRecompensa().getId(), entity.getDataResgate());
    }

    @Override
    public List<UsuarioRecompensaDto> listarTodos() {
        return usuarioRecompensaRepository.findAll()
                .stream()
                .map(entity -> new UsuarioRecompensaDto(entity.getId(), entity.getUsuarioId(), entity.getRecompensa().getId(), entity.getDataResgate()))
                .collect(Collectors.toList());
    }
}
