package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Procedimento;
import com.odontovision.Java_API.repositories.ProcedimentoRepository;
import com.odontovision.Java_API.dtos.ProcedimentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProcedimentoService {

    @Autowired
    private ProcedimentoRepository procedimentoRepository;

    public Procedimento salvarProcedimento(ProcedimentoDTO dto) {
        Procedimento procedimento = new Procedimento();
        procedimento.setNomeProcedimento(dto.getNomeProcedimento());
        procedimento.setDescricao(dto.getDescricao());
        procedimento.setCusto(dto.getCusto());
        return procedimentoRepository.save(procedimento);
    }

    public List<Procedimento> listarProcedimentos() {
        return procedimentoRepository.findAll();
    }

    public Optional<Procedimento> buscarProcedimentoPorId(Long id) {
        return procedimentoRepository.findById(id);
    }

    public void excluirProcedimento(Long id) {
        if (!procedimentoRepository.existsById(id)) {
            throw new RuntimeException("Procedimento não encontrado");
        }
        procedimentoRepository.deleteById(id);
    }
}