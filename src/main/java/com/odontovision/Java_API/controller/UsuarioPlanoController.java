package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.UsuarioPlanoDto;
import com.odontovision.Java_API.service.UsuarioPlanoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/usuario-planos")
@Validated
public class UsuarioPlanoController {

    private final UsuarioPlanoService service;

    public UsuarioPlanoController(UsuarioPlanoService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<UsuarioPlanoDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(UsuarioPlanoController.class).buscar(dto.getId())).withSelfRel(),
                        linkTo(methodOn(UsuarioPlanoController.class).listar()).withRel("usuario-planos")
                ))
                .toList();
        return CollectionModel.of(recursos,
                linkTo(methodOn(UsuarioPlanoController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<UsuarioPlanoDto>> buscar(@PathVariable Long id) {
        var dto = service.buscarPorId(id);
        var resource = EntityModel.of(dto,
                linkTo(methodOn(UsuarioPlanoController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(UsuarioPlanoController.class).listar()).withRel("usuario-planos")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<UsuarioPlanoDto>> criar(
            @RequestBody @Valid UsuarioPlanoDto dto
    ) {
        var criado = service.criar(dto);
        var resource = EntityModel.of(criado,
                linkTo(methodOn(UsuarioPlanoController.class).buscar(criado.getId())).withSelfRel(),
                linkTo(methodOn(UsuarioPlanoController.class).listar()).withRel("usuario-planos")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<UsuarioPlanoDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid UsuarioPlanoDto dto
    ) {
        var atualizado = service.atualizar(id, dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(UsuarioPlanoController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(UsuarioPlanoController.class).listar()).withRel("usuario-planos")
        );
    }

}