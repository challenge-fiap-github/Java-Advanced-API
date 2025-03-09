package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Nivel;
import com.odontovision.Java_API.repositories.NivelRepository;
import com.odontovision.Java_API.dtos.NivelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NivelService {

    @Autowired
    private NivelRepository nivelRepository;

    public Nivel salvarNivel(NivelDTO dto) {
        Nivel nivel = new Nivel();
        nivel.setDescricao(dto.getDescricao());
        nivel.setPontosNecessarios(dto.getPontosNecessarios());
        return nivelRepository.save(nivel);
    }

    public List<Nivel> listarNiveis() {
        return nivelRepository.findAll();
    }

    public Optional<Nivel> buscarNivelPorId(Long id) {
        return nivelRepository.findById(id);
    }

    public void excluirNivel(Long id) {
        if (!nivelRepository.existsById(id)) {
            throw new RuntimeException("Nível não encontrado");
        }
        nivelRepository.deleteById(id);
    }
}