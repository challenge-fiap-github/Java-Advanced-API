package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.Dentista;
import com.odontovision.Java_API.repositories.DentistaRepository;
import com.odontovision.Java_API.dtos.DentistaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {

    @Autowired
    private DentistaRepository dentistaRepository;

    public Dentista cadastrarDentista(DentistaDTO dto) {
        Dentista dentista = new Dentista();
        dentista.setNome(dto.getNome());
        dentista.setCro(dto.getCro());
        dentista.setEspecialidade(dto.getEspecialidade());
        dentista.setTelefone(dto.getTelefone());
        dentista.setEmail(dto.getEmail());

        return dentistaRepository.save(dentista);
    }

    public List<Dentista> listarDentistas() {
        return dentistaRepository.findAll();
    }

    public Optional<Dentista> buscarPorId(Long id) {
        return dentistaRepository.findById(id);
    }

    public void excluirDentista(Long id) {
        dentistaRepository.deleteById(id);
    }
}
