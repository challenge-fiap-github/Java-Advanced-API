package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Usuario;
import com.odontovision.Java_API.services.UsuarioService;
import com.odontovision.Java_API.dtos.UsuarioDTO;
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
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<EntityModel<UsuarioDTO>> cadastrarUsuario(@RequestBody UsuarioDTO dto) {
        Usuario usuario = usuarioService.salvarUsuario(dto);
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

        return ResponseEntity.ok(EntityModel.of(usuarioDTO,
                linkTo(methodOn(UsuarioController.class).buscarUsuarioPorId(usuario.getId())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<UsuarioDTO>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        List<UsuarioDTO> dtos = usuarios.stream()
                .map(UsuarioDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(UsuarioController.class).listarUsuarios()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioDTO>> buscarUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.buscarUsuarioPorId(id);

        return usuario.map(u -> ResponseEntity.ok(EntityModel.of(new UsuarioDTO(u),
                        linkTo(methodOn(UsuarioController.class).buscarUsuarioPorId(id)).withSelfRel(),
                        linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUsuario(@PathVariable Long id) {
        usuarioService.excluirUsuario(id);
        return ResponseEntity.noContent().build();
    }
}