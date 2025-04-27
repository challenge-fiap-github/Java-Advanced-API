package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.UsuarioRequestDTO;
import com.odontovision.Java_API.dto.UsuarioResponseDto;
import com.odontovision.Java_API.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<UsuarioResponseDto>> criarUsuario(@RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDto novoUsuario = usuarioService.criarUsuario(usuarioRequestDTO);
        return ResponseEntity.ok(adicionarLinksUsuario(novoUsuario));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioResponseDto>> atualizarUsuario(@PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO usuarioRequestDTO) {
        UsuarioResponseDto atualizado = usuarioService.atualizarUsuario(id, usuarioRequestDTO);
        return ResponseEntity.ok(adicionarLinksUsuario(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioResponseDto>> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioResponseDto usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(adicionarLinksUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<UsuarioResponseDto>>> listarTodosUsuarios() {
        List<EntityModel<UsuarioResponseDto>> usuarios = usuarioService.listarTodos()
                .stream()
                .map(this::adicionarLinksUsuario)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(usuarios,
                linkTo(methodOn(UsuarioController.class).listarTodosUsuarios()).withSelfRel()));
    }

    private EntityModel<UsuarioResponseDto> adicionarLinksUsuario(UsuarioResponseDto usuarioDto) {
        return EntityModel.of(usuarioDto,
                linkTo(methodOn(UsuarioController.class).buscarUsuarioPorId(usuarioDto.id())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).listarTodosUsuarios()).withRel("listar-todos"),
                linkTo(methodOn(UsuarioController.class).deletarUsuario(usuarioDto.id())).withRel("deletar")
        );
    }
}
