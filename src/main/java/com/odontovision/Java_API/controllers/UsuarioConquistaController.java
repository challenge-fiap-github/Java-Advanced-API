package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.UsuarioConquista;
import com.odontovision.Java_API.services.UsuarioConquistaService;
import com.odontovision.Java_API.dtos.UsuarioConquistaDTO;
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
@RequestMapping("/usuarios-conquistas")
public class UsuarioConquistaController {

    @Autowired
    private UsuarioConquistaService usuarioConquistaService;

    @PostMapping
    public ResponseEntity<EntityModel<UsuarioConquistaDTO>> registrarUsuarioConquista(@RequestBody UsuarioConquistaDTO dto) {
        UsuarioConquista usuarioConquista = usuarioConquistaService.salvarUsuarioConquista(dto);
        UsuarioConquistaDTO usuarioConquistaDTO = new UsuarioConquistaDTO(usuarioConquista);

        return ResponseEntity.ok(EntityModel.of(usuarioConquistaDTO,
                linkTo(methodOn(UsuarioConquistaController.class)
                        .buscarUsuarioConquista(usuarioConquista.getUsuario().getId(), usuarioConquista.getConquista().getId()))
                        .withSelfRel(),
                linkTo(methodOn(UsuarioConquistaController.class).listarUsuariosConquistas()).withRel("usuarios-conquistas")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<UsuarioConquistaDTO>> listarUsuariosConquistas() {
        List<UsuarioConquista> usuariosConquistas = usuarioConquistaService.listarUsuariosConquistas();
        List<UsuarioConquistaDTO> dtos = usuariosConquistas.stream()
                .map(UsuarioConquistaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(UsuarioConquistaController.class).listarUsuariosConquistas()).withSelfRel()));
    }

    @GetMapping("/{usuarioId}/{conquistaId}")
    public ResponseEntity<EntityModel<UsuarioConquistaDTO>> buscarUsuarioConquista(
            @PathVariable Long usuarioId, @PathVariable Long conquistaId) {
        Optional<UsuarioConquista> usuarioConquista = usuarioConquistaService.buscarUsuarioConquista(usuarioId, conquistaId);

        return usuarioConquista.map(uc -> ResponseEntity.ok(EntityModel.of(new UsuarioConquistaDTO(uc),
                        linkTo(methodOn(UsuarioConquistaController.class)
                                .buscarUsuarioConquista(usuarioId, conquistaId)).withSelfRel(),
                        linkTo(methodOn(UsuarioConquistaController.class).listarUsuariosConquistas()).withRel("usuarios-conquistas"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{usuarioId}/{conquistaId}")
    public ResponseEntity<Void> excluirUsuarioConquista(@PathVariable Long usuarioId, @PathVariable Long conquistaId) {
        usuarioConquistaService.excluirUsuarioConquista(usuarioId, conquistaId);
        return ResponseEntity.noContent().build();
    }
}