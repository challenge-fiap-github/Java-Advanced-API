package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Notificacao;
import com.odontovision.Java_API.repositories.NotificacaoRepository;
import com.odontovision.Java_API.dtos.NotificacaoDTO;
import com.odontovision.Java_API.entities.Usuario;
import com.odontovision.Java_API.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Notificacao salvarNotificacao(NotificacaoDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Notificacao notificacao = new Notificacao();
        notificacao.setTitulo(dto.getTitulo());
        notificacao.setConteudo(dto.getConteudo());
        notificacao.setDataEnvio(new Date()); // Define a data de envio como a atual
        notificacao.setUsuario(usuario);

        return notificacaoRepository.save(notificacao);
    }

    public List<Notificacao> listarNotificacoes() {
        return notificacaoRepository.findAll();
    }

    public Optional<Notificacao> buscarNotificacaoPorId(Long id) {
        return notificacaoRepository.findById(id);
    }

    public void excluirNotificacao(Long id) {
        if (!notificacaoRepository.existsById(id)) {
            throw new RuntimeException("Notificação não encontrada");
        }
        notificacaoRepository.deleteById(id);
    }
}