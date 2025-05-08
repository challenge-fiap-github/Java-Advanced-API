package com.odontovision.Java_API.service.impl;

import com.odontovision.Java_API.entity.Auditoria;
import com.odontovision.Java_API.repository.AuditoriaRepository;
import com.odontovision.Java_API.service.AuditoriaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class AuditoriaServiceImpl implements AuditoriaService {

    private final AuditoriaRepository repository;

    public AuditoriaServiceImpl(AuditoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Auditoria> listarTodas() {
        return repository.findAll();
    }

    @Override
    public Optional<Auditoria> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Auditoria criar(Auditoria auditoria) {
        return repository.save(auditoria);
    }
}