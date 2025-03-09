package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.UsuarioConquista;
import com.odontovision.Java_API.entities.UsuarioConquistaId;
import com.odontovision.Java_API.entities.Usuario;
import com.odontovision.Java_API.entities.Conquista;
import com.odontovision.Java_API.repositories.UsuarioConquistaRepository;
import com.odontovision.Java_API.repositories.UsuarioRepository;
import com.odontovision.Java_API.repositories.ConquistaRepository;
import com.odontovision.Java_API.dtos.UsuarioConquistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioConquistaService {

    @Autowired
    private UsuarioConquistaRepository usuarioConquistaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConquistaRepository conquistaRepository;

    public UsuarioConquista salvarUsuarioConquista(UsuarioConquistaDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Conquista conquista = conquistaRepository.findById(dto.getConquistaId())
                .orElseThrow(() -> new RuntimeException("Conquista não encontrada"));

        UsuarioConquistaId id = new UsuarioConquistaId(usuario.getId(), conquista.getId());
        if (usuarioConquistaRepository.existsById(id)) {
            throw new RuntimeException("O usuário já possui essa conquista!");
        }

        UsuarioConquista usuarioConquista = new UsuarioConquista(usuario, conquista,
                dto.getDataObtencao() != null ? dto.getDataObtencao() : new Date());

        return usuarioConquistaRepository.save(usuarioConquista);
    }

    public List<UsuarioConquista> listarUsuariosConquistas() {
        return usuarioConquistaRepository.findAll();
    }

    public Optional<UsuarioConquista> buscarUsuarioConquista(Long usuarioId, Long conquistaId) {
        UsuarioConquistaId id = new UsuarioConquistaId(usuarioId, conquistaId);
        return usuarioConquistaRepository.findById(id);
    }

    public void excluirUsuarioConquista(Long usuarioId, Long conquistaId) {
        UsuarioConquistaId id = new UsuarioConquistaId(usuarioId, conquistaId);
        if (!usuarioConquistaRepository.existsById(id)) {
            throw new RuntimeException("Usuário-Conquista não encontrado");
        }
        usuarioConquistaRepository.deleteById(id);
    }
}