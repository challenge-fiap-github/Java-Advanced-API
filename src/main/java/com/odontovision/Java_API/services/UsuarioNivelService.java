package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.UsuarioNivel;
import com.odontovision.Java_API.entities.UsuarioNivelId;
import com.odontovision.Java_API.entities.Usuario;
import com.odontovision.Java_API.entities.Nivel;
import com.odontovision.Java_API.repositories.UsuarioNivelRepository;
import com.odontovision.Java_API.repositories.UsuarioRepository;
import com.odontovision.Java_API.repositories.NivelRepository;
import com.odontovision.Java_API.dtos.UsuarioNivelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioNivelService {

    @Autowired
    private UsuarioNivelRepository usuarioNivelRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private NivelRepository nivelRepository;

    public UsuarioNivel salvarUsuarioNivel(UsuarioNivelDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Nivel nivel = nivelRepository.findById(dto.getNivelId())
                .orElseThrow(() -> new RuntimeException("Nível não encontrado"));

        UsuarioNivelId id = new UsuarioNivelId(usuario.getId(), nivel.getId());
        if (usuarioNivelRepository.existsById(id)) {
            throw new RuntimeException("O usuário já possui esse nível!");
        }

        UsuarioNivel usuarioNivel = new UsuarioNivel(usuario, nivel,
                dto.getPontosAtuais(),
                dto.getDataUltimaAtualizacao() != null ? dto.getDataUltimaAtualizacao() : new Date());

        return usuarioNivelRepository.save(usuarioNivel);
    }

    public List<UsuarioNivel> listarUsuariosNiveis() {
        return usuarioNivelRepository.findAll();
    }

    public Optional<UsuarioNivel> buscarUsuarioNivel(Long usuarioId, Long nivelId) {
        UsuarioNivelId id = new UsuarioNivelId(usuarioId, nivelId);
        return usuarioNivelRepository.findById(id);
    }

    public void excluirUsuarioNivel(Long usuarioId, Long nivelId) {
        UsuarioNivelId id = new UsuarioNivelId(usuarioId, nivelId);
        if (!usuarioNivelRepository.existsById(id)) {
            throw new RuntimeException("Usuário-Nível não encontrado");
        }
        usuarioNivelRepository.deleteById(id);
    }
}