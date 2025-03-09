package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.EnderecoUsuario;
import com.odontovision.Java_API.repositories.EnderecoUsuarioRepository;
import com.odontovision.Java_API.dtos.EnderecoUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoUsuarioService {

    @Autowired
    private EnderecoUsuarioRepository enderecoUsuarioRepository;

    public EnderecoUsuario salvarEnderecoUsuario(EnderecoUsuarioDTO dto) {
        EnderecoUsuario endereco = new EnderecoUsuario();
        endereco.setUsuarioId(dto.getUsuarioId());
        endereco.setLogradouro(dto.getLogradouro());
        endereco.setNumero(dto.getNumero());
        endereco.setCidade(dto.getCidade());
        endereco.setEstado(dto.getEstado());
        endereco.setCep(dto.getCep());
        endereco.setComplemento(dto.getComplemento());

        return enderecoUsuarioRepository.save(endereco);
    }

    public List<EnderecoUsuario> listarEnderecos() {
        return enderecoUsuarioRepository.findAll();
    }

    public Optional<EnderecoUsuario> buscarEnderecoPorId(Long id) {
        return enderecoUsuarioRepository.findById(id);
    }

    public void excluirEndereco(Long id) {
        enderecoUsuarioRepository.deleteById(id);
    }
}
