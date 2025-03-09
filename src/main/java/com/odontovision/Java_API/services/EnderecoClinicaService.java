package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.EnderecoClinica;
import com.odontovision.Java_API.repositories.EnderecoClinicaRepository;
import com.odontovision.Java_API.dtos.EnderecoClinicaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoClinicaService {

    @Autowired
    private EnderecoClinicaRepository enderecoClinicaRepository;

    public EnderecoClinica salvarEnderecoClinica(EnderecoClinicaDTO dto) {
        EnderecoClinica endereco = new EnderecoClinica();
        endereco.setDentistaId(dto.getDentistaId());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());

        return enderecoClinicaRepository.save(endereco);
    }

    public List<EnderecoClinica> listarEnderecosClinica() {
        return enderecoClinicaRepository.findAll();
    }

    public Optional<EnderecoClinica> buscarEnderecoClinicaPorId(Long id) {
        return enderecoClinicaRepository.findById(id);
    }

    public void excluirEnderecoClinica(Long id) {
        enderecoClinicaRepository.deleteById(id);
    }
}
