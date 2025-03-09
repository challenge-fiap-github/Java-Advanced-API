package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Conquista;
import com.odontovision.Java_API.repositories.ConquistaRepository;
import com.odontovision.Java_API.dtos.ConquistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConquistaService {

    @Autowired
    private ConquistaRepository conquistaRepository;

    public Conquista cadastrarConquista(ConquistaDTO dto) {
        Conquista conquista = new Conquista();
        conquista.setNome(dto.getNome());
        conquista.setDescricao(dto.getDescricao());
        conquista.setPontosBonus(dto.getPontosBonus());
        conquista.setDataExpiracao(dto.getDataExpiracao());

        return conquistaRepository.save(conquista);
    }

    public List<Conquista> listarConquistas() {
        return conquistaRepository.findAll();
    }

    public Optional<Conquista> buscarConquistaPorId(Long id) {
        return conquistaRepository.findById(id);
    }

    public void excluirConquista(Long id) {
        conquistaRepository.deleteById(id);
    }
}
