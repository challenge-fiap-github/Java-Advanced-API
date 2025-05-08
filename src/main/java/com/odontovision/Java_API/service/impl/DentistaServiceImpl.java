package com.odontovision.Java_API.service.impl;
import com.odontovision.Java_API.entity.Dentista;

import com.odontovision.Java_API.exception.DentistaNotFoundException;
import com.odontovision.Java_API.repository.DentistaRepository;
import com.odontovision.Java_API.service.DentistaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DentistaServiceImpl implements DentistaService {

    private final DentistaRepository repo;

    public DentistaServiceImpl(DentistaRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Dentista> listarTodos() {
        return repo.findAll();
    }

    @Override
    public Optional<Dentista> buscarPorId(Long id) {
        return repo.findById(id);
    }

    @Override
    public Dentista criar(Dentista d) {
        // aqui você pode adicionar regras de negócio (ex.: validar CRO único etc)
        return repo.save(d);
    }

    @Override
    public Dentista atualizar(Long id, Dentista d) {
        Dentista existente = repo.findById(id)
                .orElseThrow(() -> new DentistaNotFoundException(id));
        existente.setNome(d.getNome());
        existente.setCro(d.getCro());
        existente.setEspecialidade(d.getEspecialidade());
        existente.setTelefone(d.getTelefone());
        existente.setEmail(d.getEmail());
        return repo.save(existente);
    }

    @Override
    public void excluir(Long id) {
        if (!repo.existsById(id)) {
            throw new DentistaNotFoundException(id);
        }
        repo.deleteById(id);
    }
}
