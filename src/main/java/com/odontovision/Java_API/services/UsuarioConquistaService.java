package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.UsuarioConquista;
import com.odontovision.Java_API.repositories.UsuarioConquistaRepository;
import com.odontovision.Java_API.dtos.UsuarioConquistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioConquistaService {

    @Autowired
    private UsuarioConquistaRepository usuarioConquistaRepository;

    public UsuarioConquista registrarUsuarioConquista(UsuarioConquistaDTO dto) {
        UsuarioConquista usuarioConquista = new UsuarioConquista();
        usuarioConquista.setUsuarioId(dto.getUsuarioId());
        usuarioConquista.setConquistaId(dto.getConquistaId());
        usuarioConquista.setDataObtencao(dto.getDataObtencao());

        return usuarioConquistaRepository.save(usuarioConquista);
    }

    public List<UsuarioConquista> listarUsuariosConquistas() {
        return usuarioConquistaRepository.findAll();
    }

    public Optional<UsuarioConquista> buscarUsuarioConquistaPorId(Long id) {
        return usuarioConquistaRepository.findById(id);
    }

    public void excluirUsuarioConquista(Long id) {
        usuarioConquistaRepository.deleteById(id);
    }
}
