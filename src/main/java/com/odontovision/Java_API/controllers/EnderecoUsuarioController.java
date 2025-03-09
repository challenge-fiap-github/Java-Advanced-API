package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.EnderecoUsuario;
import com.odontovision.Java_API.services.EnderecoUsuarioService;
import com.odontovision.Java_API.dtos.EnderecoUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/enderecos-usuario")
public class EnderecoUsuarioController {

    @Autowired
    private EnderecoUsuarioService enderecoUsuarioService;

    @PostMapping
    public ResponseEntity<EntityModel<EnderecoUsuarioDTO>> cadastrarEnderecoUsuario(@RequestBody EnderecoUsuarioDTO dto) {
        EnderecoUsuario enderecoUsuario = enderecoUsuarioService.salvarEnderecoUsuario(dto);
        EnderecoUsuarioDTO enderecoUsuarioDTO = new EnderecoUsuarioDTO(enderecoUsuario);

        return ResponseEntity.ok(EntityModel.of(enderecoUsuarioDTO,
                linkTo(methodOn(EnderecoUsuarioController.class).buscarEnderecoUsuarioPorId(enderecoUsuario.getId())).withSelfRel(),
                linkTo(methodOn(EnderecoUsuarioController.class).listarEnderecosUsuario()).withRel("enderecos-usuario")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EnderecoUsuarioDTO>> listarEnderecosUsuario() {
        List<EnderecoUsuario> enderecos = enderecoUsuarioService.listarEnderecosUsuario();
        List<EnderecoUsuarioDTO> dtos = enderecos.stream()
                .map(EnderecoUsuarioDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(EnderecoUsuarioController.class).listarEnderecosUsuario()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EnderecoUsuarioDTO>> buscarEnderecoUsuarioPorId(@PathVariable Long id) {
        Optional<EnderecoUsuario> enderecoUsuario = enderecoUsuarioService.buscarEnderecoPorId(id);

        return enderecoUsuario.map(e -> ResponseEntity.ok(EntityModel.of(new EnderecoUsuarioDTO(e),
                        linkTo(methodOn(EnderecoUsuarioController.class).buscarEnderecoUsuarioPorId(id)).withSelfRel(),
                        linkTo(methodOn(EnderecoUsuarioController.class).listarEnderecosUsuario()).withRel("enderecos-usuario"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEnderecoUsuario(@PathVariable Long id) {
        enderecoUsuarioService.excluirEnderecoUsuario(id);
        return ResponseEntity.noContent().build();
    }
}
