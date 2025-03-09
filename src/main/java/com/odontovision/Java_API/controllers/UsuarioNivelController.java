package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.UsuarioNivel;
import com.odontovision.Java_API.services.UsuarioNivelService;
import com.odontovision.Java_API.dtos.UsuarioNivelDTO;
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
@RequestMapping("/usuarios-niveis")
public class UsuarioNivelController {

    @Autowired
    private UsuarioNivelService usuarioNivelService;

    @PostMapping
    public ResponseEntity<EntityModel<UsuarioNivelDTO>> registrarUsuarioNivel(@RequestBody UsuarioNivelDTO dto) {
        UsuarioNivel usuarioNivel = usuarioNivelService.salvarUsuarioNivel(dto);
        UsuarioNivelDTO usuarioNivelDTO = new UsuarioNivelDTO(usuarioNivel);

        return ResponseEntity.ok(EntityModel.of(usuarioNivelDTO,
                linkTo(methodOn(UsuarioNivelController.class)
                        .buscarUsuarioNivel(usuarioNivel.getUsuario().getId(), usuarioNivel.getNivel().getId()))
                        .withSelfRel(),
                linkTo(methodOn(UsuarioNivelController.class).listarUsuariosNiveis()).withRel("usuarios-niveis")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<UsuarioNivelDTO>> listarUsuariosNiveis() {
        List<UsuarioNivel> usuariosNiveis = usuarioNivelService.listarUsuariosNiveis();
        List<UsuarioNivelDTO> dtos = usuariosNiveis.stream()
                .map(UsuarioNivelDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(UsuarioNivelController.class).listarUsuariosNiveis()).withSelfRel()));
    }

    @GetMapping("/{usuarioId}/{nivelId}")
    public ResponseEntity<EntityModel<UsuarioNivelDTO>> buscarUsuarioNivel(
            @PathVariable Long usuarioId, @PathVariable Long nivelId) {
        Optional<UsuarioNivel> usuarioNivel = usuarioNivelService.buscarUsuarioNivel(usuarioId, nivelId);

        return usuarioNivel.map(un -> ResponseEntity.ok(EntityModel.of(new UsuarioNivelDTO(un),
                        linkTo(methodOn(UsuarioNivelController.class)
                                .buscarUsuarioNivel(usuarioId, nivelId)).withSelfRel(),
                        linkTo(methodOn(UsuarioNivelController.class).listarUsuariosNiveis()).withRel("usuarios-niveis"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{usuarioId}/{nivelId}")
    public ResponseEntity<Void> excluirUsuarioNivel(@PathVariable Long usuarioId, @PathVariable Long nivelId) {
        usuarioNivelService.excluirUsuarioNivel(usuarioId, nivelId);
        return ResponseEntity.noContent().build();
    }
}