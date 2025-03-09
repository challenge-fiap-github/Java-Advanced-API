package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Notificacao;
import com.odontovision.Java_API.repositories.NotificacaoRepository;
import com.odontovision.Java_API.dtos.NotificacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao registrarNotificacao(NotificacaoDTO dto) {
        Notificacao notificacao = new Notificacao();
        notificacao.setTitulo(dto.getTitulo());
        notificacao.setConteudo(dto.getConteudo());
        notificacao.setDataEnvio(dto.getDataEnvio());
        notificacao.setUsuarioId(dto.getUsuarioId());

        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> buscarNotificacaoPorId(Long id) {
        return notificacaoRepository.findById(id);
    }

    public void excluirNotificacao(Long id) {
        notificacaoRepository.deleteById(id);
    }
}
