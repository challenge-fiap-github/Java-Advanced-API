package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Consulta;
import com.odontovision.Java_API.repositories.ConsultaRepository;
import com.odontovision.Java_API.dtos.ConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    public Consulta agendarConsulta(ConsultaDTO dto) {
        Consulta consulta = new Consulta();
        consulta.setUsuarioId(dto.getUsuarioId());
        consulta.setDentistaId(dto.getDentistaId());
        consulta.setStatusId(dto.getStatusId());
        consulta.setTipoConsultaId(dto.getTipoConsultaId());
        consulta.setDataHora(dto.getDataHora());
        consulta.setObservacoes(dto.getObservacoes());

        return consultaRepository.save(consulta);
    }

    public List<Consulta> listarConsultas() {
        return consultaRepository.findAll();
    }

    public Optional<Consulta> buscarConsultaPorId(Long id) {
        return consultaRepository.findById(id);
    }

    public void cancelarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
