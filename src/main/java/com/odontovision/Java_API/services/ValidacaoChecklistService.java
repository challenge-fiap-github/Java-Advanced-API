package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.ValidacaoChecklist;
import com.odontovision.Java_API.repositories.ValidacaoChecklistRepository;
import com.odontovision.Java_API.dtos.ValidacaoChecklistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidacaoChecklistService {

    @Autowired
    private ValidacaoChecklistRepository validacaoChecklistRepository;

    public ValidacaoChecklist registrarValidacao(ValidacaoChecklistDTO dto) {
        ValidacaoChecklist validacao = new ValidacaoChecklist();
        validacao.setUsuarioId(dto.getUsuarioId());
        validacao.setConsultaId(dto.getConsultaId());
        validacao.setDataValidacao(dto.getDataValidacao());
        validacao.setStatusValidacao(dto.getStatusValidacao());
        validacao.setPontosBonus(dto.getPontosBonus());

        return validacaoChecklistRepository.save(validacao);
    }

    public List<ValidacaoChecklist> listarValidacoes() {
        return validacaoChecklistRepository.findAll();
    }

    public Optional<ValidacaoChecklist> buscarValidacaoPorId(Long id) {
        return validacaoChecklistRepository.findById(id);
    }

    public void excluirValidacao(Long id) {
        validacaoChecklistRepository.deleteById(id);
    }
}
