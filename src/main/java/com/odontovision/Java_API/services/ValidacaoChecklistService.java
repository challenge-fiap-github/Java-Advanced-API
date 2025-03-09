package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.ValidacaoChecklist;
import com.odontovision.Java_API.entities.Usuario;
import com.odontovision.Java_API.entities.Consulta;
import com.odontovision.Java_API.repositories.ValidacaoChecklistRepository;
import com.odontovision.Java_API.repositories.UsuarioRepository;
import com.odontovision.Java_API.repositories.ConsultaRepository;
import com.odontovision.Java_API.dtos.ValidacaoChecklistDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ValidacaoChecklistService {

    @Autowired
    private ValidacaoChecklistRepository validacaoChecklistRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public ValidacaoChecklist salvarValidacaoChecklist(ValidacaoChecklistDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Consulta consulta = consultaRepository.findById(dto.getConsultaId())
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        ValidacaoChecklist validacaoChecklist = new ValidacaoChecklist();
        validacaoChecklist.setUsuario(usuario);
        validacaoChecklist.setConsulta(consulta);
        validacaoChecklist.setDataValidacao(dto.getDataValidacao() != null ? dto.getDataValidacao() : new Date());
        validacaoChecklist.setStatusValidacao(dto.getStatusValidacao());
        validacaoChecklist.setPontosBonus(dto.getPontosBonus());

        return validacaoChecklistRepository.save(validacaoChecklist);
    }

    public List<ValidacaoChecklist> listarValidacoesChecklist() {
        return validacaoChecklistRepository.findAll();
    }

    public Optional<ValidacaoChecklist> buscarValidacaoChecklist(Long id) {
        return validacaoChecklistRepository.findById(id);
    }

    public void excluirValidacaoChecklist(Long id) {
        if (!validacaoChecklistRepository.existsById(id)) {
            throw new RuntimeException("Validação de Checklist não encontrada");
        }
        validacaoChecklistRepository.deleteById(id);
    }
}