package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.dto.EnderecoClinicaDto;
import com.odontovision.Java_API.entity.Dentista;
import com.odontovision.Java_API.entity.EnderecoClinica;
import com.odontovision.Java_API.exception.EnderecoClinicaNotFoundException;
import com.odontovision.Java_API.exception.DentistaNotFoundException;
import com.odontovision.Java_API.mapper.EnderecoClinicaMapper;
import com.odontovision.Java_API.repository.DentistaRepository;
import com.odontovision.Java_API.repository.EnderecoClinicaRepository;
import com.odontovision.Java_API.service.EnderecoClinicaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EnderecoClinicaServiceImpl implements EnderecoClinicaService {

    private final EnderecoClinicaRepository repo;
    private final DentistaRepository dentistaRepo;

    public EnderecoClinicaServiceImpl(EnderecoClinicaRepository repo,
                                      DentistaRepository dentistaRepo) {
        this.repo = repo;
        this.dentistaRepo = dentistaRepo;
    }

    @Override
    public List<EnderecoClinicaDto> listarTodos() {
        return repo.findAll()
                .stream()
                .map(EnderecoClinicaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public EnderecoClinicaDto buscarPorId(Long id) {
        EnderecoClinica e = repo.findById(id)
                .orElseThrow(() -> new EnderecoClinicaNotFoundException(id));
        return EnderecoClinicaMapper.toDto(e);
    }

    @Override
    public EnderecoClinicaDto criar(EnderecoClinicaDto dto) {
        // converte DTO → entidade
        EnderecoClinica e = EnderecoClinicaMapper.toEntity(dto);

        // resolve o dentista
        Dentista dentista = dentistaRepo.findById(dto.dentistaId())
                .orElseThrow(() -> new DentistaNotFoundException(dto.dentistaId()));
        e.setDentista(dentista);

        EnderecoClinica salvo = repo.save(e);
        return EnderecoClinicaMapper.toDto(salvo);
    }

    @Override
    public EnderecoClinicaDto atualizar(Long id, EnderecoClinicaDto dto) {
        EnderecoClinica existente = repo.findById(id)
                .orElseThrow(() -> new EnderecoClinicaNotFoundException(id));

        // atualiza campos
        existente.setLogradouro(dto.logradouro());
        existente.setNumero(dto.numero());
        existente.setCidade(dto.cidade());
        existente.setEstado(dto.estado());
        existente.setCep(dto.cep());
        existente.setComplemento(dto.complemento());

        // atualiza o dentista, se mudou
        if (!existente.getDentista().getId().equals(dto.dentistaId())) {
            Dentista novo = dentistaRepo.findById(dto.dentistaId())
                    .orElseThrow(() -> new DentistaNotFoundException(dto.dentistaId()));
            existente.setDentista(novo);
        }

        EnderecoClinica atualizado = repo.save(existente);
        return EnderecoClinicaMapper.toDto(atualizado);
    }

    @Override
    public void excluir(Long id) {
        // dispara EnderecoClinicaNotFoundException se não existir
        repo.findById(id).orElseThrow(() -> new EnderecoClinicaNotFoundException(id));
        repo.deleteById(id);
    }
}