package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.PlanoOdontologico;
import com.odontovision.Java_API.repositories.PlanoOdontologicoRepository;
import com.odontovision.Java_API.dtos.PlanoOdontologicoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanoOdontologicoService {

    @Autowired
    private PlanoOdontologicoRepository planoOdontologicoRepository;

    public PlanoOdontologico salvarPlano(PlanoOdontologicoDTO dto) {
        PlanoOdontologico plano = new PlanoOdontologico();
        plano.setNomePlano(dto.getNomePlano());
        plano.setDescricao(dto.getDescricao());
        plano.setPreco(dto.getPreco());
        plano.setValidade(dto.getValidade());
        return planoOdontologicoRepository.save(plano);
    }

    public List<PlanoOdontologico> listarPlanos() {
        return planoOdontologicoRepository.findAll();
    }

    public Optional<PlanoOdontologico> buscarPlanoPorId(Long id) {
        return planoOdontologicoRepository.findById(id);
    }

    public void excluirPlano(Long id) {
        if (!planoOdontologicoRepository.existsById(id)) {
            throw new RuntimeException("Plano odontológico não encontrado");
        }
        planoOdontologicoRepository.deleteById(id);
    }
}