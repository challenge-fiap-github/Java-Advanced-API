package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.UsuarioNivel;
import com.odontovision.Java_API.repositories.UsuarioNivelRepository;
import com.odontovision.Java_API.dtos.UsuarioNivelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioNivelService {

    @Autowired
    private UsuarioNivelRepository usuarioNivelRepository;

    public UsuarioNivel registrarUsuarioNivel(UsuarioNivelDTO dto) {
        UsuarioNivel usuarioNivel = new UsuarioNivel();
        usuarioNivel.setUsuarioId(dto.getUsuarioId());
        usuarioNivel.setNivelId(dto.getNivelId());
        usuarioNivel.setPontosAtuais(dto.getPontosAtuais());
        usuarioNivel.setDataUltimaAtualizacao(dto.getDataUltimaAtualizacao());

        return usuarioNivelRepository.save(usuarioNivel);
    }

    public List<UsuarioNivel> listarUsuariosNiveis() {
        return usuarioNivelRepository.findAll();
    }

    public Optional<UsuarioNivel> buscarUsuarioNivelPorId(Long id) {
        return usuarioNivelRepository.findById(id);
    }

    public void excluirUsuarioNivel(Long id) {
        usuarioNivelRepository.deleteById(id);
    }
}
