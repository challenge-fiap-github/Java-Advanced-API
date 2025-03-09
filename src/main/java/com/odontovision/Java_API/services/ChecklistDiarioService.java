package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.ChecklistDiario;
import com.odontovision.Java_API.entities.Consulta;
import com.odontovision.Java_API.entities.Usuario;
import com.odontovision.Java_API.repositories.ChecklistDiarioRepository;
import com.odontovision.Java_API.repositories.ConsultaRepository;
import com.odontovision.Java_API.repositories.UsuarioRepository;
import com.odontovision.Java_API.dtos.ChecklistDiarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ChecklistDiarioService {

    @Autowired
    private ChecklistDiarioRepository checklistDiarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ConsultaRepository consultaRepository;

    public ChecklistDiario registrarChecklist(ChecklistDiarioDTO dto) {
        ChecklistDiario checklist = new ChecklistDiario();

        // Buscar o usuário no banco antes de associar
        Usuario usuario = usuarioRepository.findById(dto.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        checklist.setUsuario(usuario);

        checklist.setData(dto.getData());
        checklist.setEscovacao(dto.getEscovacao());
        checklist.setFioDental(dto.getFioDental());

        // Verifica se a consulta de validação existe antes de associar
        if (dto.getConsultaValidacao() != null) {
            Consulta consulta = consultaRepository.findById(dto.getConsultaValidacao().getId())
                    .orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
            checklist.setConsultaValidacao(consulta);
        }

        return checklistDiarioRepository.save(checklist);
    }

    public List<ChecklistDiario> listarChecklists() {
        return checklistDiarioRepository.findAll();
    }

    public Optional<ChecklistDiario> buscarChecklistPorId(Long id) {
        return checklistDiarioRepository.findById(id);
    }

    public void excluirChecklist(Long id) {
        checklistDiarioRepository.deleteById(id);
    }
}