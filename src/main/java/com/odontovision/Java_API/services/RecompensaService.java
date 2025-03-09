package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Recompensa;
import com.odontovision.Java_API.repositories.RecompensaRepository;
import com.odontovision.Java_API.dtos.RecompensaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RecompensaService {

    @Autowired
    private RecompensaRepository recompensaRepository;

    public Recompensa cadastrarRecompensa(RecompensaDTO dto) {
        Recompensa recompensa = new Recompensa();
        recompensa.setDescricao(dto.getDescricao());
        recompensa.setPontosNecessarios(dto.getPontosNecessarios());
        recompensa.setQuantidadeDisponivel(dto.getQuantidadeDisponivel());
        recompensa.setDataExpiracao(dto.getDataExpiracao());

        return recompensaRepository.save(recompensa);
    }

    public List<Recompensa> listarRecompensas() {
        return recompensaRepository.findAll();
    }

    public Optional<Recompensa> buscarRecompensaPorId(Long id) {
        return recompensaRepository.findById(id);
    }

    public void excluirRecompensa(Long id) {
        recompensaRepository.deleteById(id);
    }
}
