package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.ConsultaRequestDto;
import com.odontovision.Java_API.dto.ConsultaResponseDto;
import com.odontovision.Java_API.entity.Consulta;
import com.odontovision.Java_API.entity.Dentista;
import com.odontovision.Java_API.entity.StatusConsulta;
import com.odontovision.Java_API.entity.TipoConsulta;
import com.odontovision.Java_API.entity.Usuario;
import com.odontovision.Java_API.exception.ResourceNotFoundException;
import com.odontovision.Java_API.mapper.ConsultaMapper;
import com.odontovision.Java_API.repository.ConsultaRepository;
import com.odontovision.Java_API.repository.DentistaRepository;
import com.odontovision.Java_API.repository.StatusConsultaRepository;
import com.odontovision.Java_API.repository.TipoConsultaRepository;
import com.odontovision.Java_API.repository.UsuarioRepository;
import com.odontovision.Java_API.service.ConsultaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;
    private final DentistaRepository dentistaRepository;
    private final StatusConsultaRepository statusConsultaRepository;
    private final TipoConsultaRepository tipoConsultaRepository;

    public ConsultaServiceImpl(ConsultaRepository consultaRepository,
                               UsuarioRepository usuarioRepository,
                               DentistaRepository dentistaRepository,
                               StatusConsultaRepository statusConsultaRepository,
                               TipoConsultaRepository tipoConsultaRepository) {
        this.consultaRepository = consultaRepository;
        this.usuarioRepository = usuarioRepository;
        this.dentistaRepository = dentistaRepository;
        this.statusConsultaRepository = statusConsultaRepository;
        this.tipoConsultaRepository = tipoConsultaRepository;
    }

    @Override
    public ConsultaResponseDto criarConsulta(ConsultaRequestDto dto) {
        // Busca e valida cada entidade referenciada
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));
        Dentista dentista = dentistaRepository.findById(dto.getDentistaId())
                .orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado com ID: " + dto.getDentistaId()));
        StatusConsulta status = statusConsultaRepository.findById(dto.getStatusId())
                .orElseThrow(() -> new ResourceNotFoundException("Status de consulta não encontrado com ID: " + dto.getStatusId()));
        TipoConsulta tipo = tipoConsultaRepository.findById(dto.getTipoConsultaId())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de consulta não encontrado com ID: " + dto.getTipoConsultaId()));

        // Monta a entidade e salva
        Consulta consulta = new Consulta();
        consulta.setDataHora(dto.getDataHora());
        consulta.setUsuario(usuario);
        consulta.setDentista(dentista);
        consulta.setStatusConsulta(status);
        consulta.setTipoConsulta(tipo);
        consulta.setObservacoes(dto.getObservacoes());

        Consulta salvo = consultaRepository.save(consulta);
        return ConsultaMapper.toResponseDto(salvo);
    }

    @Override
    public ConsultaResponseDto atualizarConsulta(Long id, ConsultaRequestDto dto) {
        Consulta existente = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));

        // Busca e valida referências novamente
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado com ID: " + dto.getUsuarioId()));
        Dentista dentista = dentistaRepository.findById(dto.getDentistaId())
                .orElseThrow(() -> new ResourceNotFoundException("Dentista não encontrado com ID: " + dto.getDentistaId()));
        StatusConsulta status = statusConsultaRepository.findById(dto.getStatusId())
                .orElseThrow(() -> new ResourceNotFoundException("Status de consulta não encontrado com ID: " + dto.getStatusId()));
        TipoConsulta tipo = tipoConsultaRepository.findById(dto.getTipoConsultaId())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de consulta não encontrado com ID: " + dto.getTipoConsultaId()));

        existente.setDataHora(dto.getDataHora());
        existente.setUsuario(usuario);
        existente.setDentista(dentista);
        existente.setStatusConsulta(status);
        existente.setTipoConsulta(tipo);
        existente.setObservacoes(dto.getObservacoes());

        Consulta atualizado = consultaRepository.save(existente);
        return ConsultaMapper.toResponseDto(atualizado);
    }

    @Override
    public void deletarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
        consultaRepository.delete(consulta);
    }

    @Override
    public ConsultaResponseDto buscarPorId(Long id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
        return ConsultaMapper.toResponseDto(consulta);
    }

    @Override
    public List<ConsultaResponseDto> listarTodas() {
        return consultaRepository.findAll().stream()
                .map(ConsultaMapper::toResponseDto)
                .collect(Collectors.toList());
    }


    @Override
    public Consulta buscarEntidadePorId(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada com ID: " + id));
    }

}