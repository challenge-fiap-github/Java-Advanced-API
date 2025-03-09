package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Pontuacao;
import com.odontovision.Java_API.repositories.PontuacaoRepository;
import com.odontovision.Java_API.dtos.PontuacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PontuacaoService {

    @Autowired
    private PontuacaoRepository pontuacaoRepository;

    public Pontuacao registrarPontuacao(PontuacaoDTO dto) {
        Pontuacao pontuacao = new Pontuacao();
        pontuacao.setUsuarioId(dto.getUsuarioId());
        pontuacao.setPontos(dto.getPontos());
        pontuacao.setDataRegistro(dto.getDataRegistro());
        pontuacao.setCicloInicial(dto.getCicloInicial());
        pontuacao.setCicloFinal(dto.getCicloFinal());

        return pontuacaoRepository.save(pontuacao);
    }

    public List<Pontuacao> listarPontuacoes() {
        return pontuacaoRepository.findAll();
    }

    public Optional<Pontuacao> buscarPontuacaoPorId(Long id) {
        return pontuacaoRepository.findById(id);
    }

    public void excluirPontuacao(Long id) {
        pontuacaoRepository.deleteById(id);
    }
}
