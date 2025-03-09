package com.odontovision.Java_API.services;

import com.odontovision.Java_API.entities.EnderecoUsuario;
import com.odontovision.Java_API.repositories.EnderecoUsuarioRepository;
import com.odontovision.Java_API.dtos.EnderecoUsuarioDTO;
import com.odontovision.Java_API.repositories.UsuarioRepository;
import com.odontovision.Java_API.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoUsuarioService {

    @Autowired
    private EnderecoUsuarioRepository enderecoUsuarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public EnderecoUsuario salvarEnderecoUsuario(EnderecoUsuarioDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        EnderecoUsuario enderecoUsuario = new EnderecoUsuario();
        enderecoUsuario.setUsuario(usuario);
        enderecoUsuario.setLogradouro(dto.getLogradouro());
        enderecoUsuario.setNumero(dto.getNumero());
        enderecoUsuario.setCidade(dto.getCidade());
        enderecoUsuario.setEstado(dto.getEstado());
        enderecoUsuario.setCep(dto.getCep());
        enderecoUsuario.setComplemento(dto.getComplemento());

        return enderecoUsuarioRepository.save(enderecoUsuario);
    }

    public List<EnderecoUsuario> listarEnderecosUsuario() {
        return enderecoUsuarioRepository.findAll();
    }

    public Optional<EnderecoUsuario> buscarEnderecoPorId(Long id) {
        return enderecoUsuarioRepository.findById(id);
    }

    public void excluirEnderecoUsuario(Long id) {
        if (!enderecoUsuarioRepository.existsById(id)) {
            throw new RuntimeException("Endereço de usuário não encontrado");
        }
        enderecoUsuarioRepository.deleteById(id);
    }
}