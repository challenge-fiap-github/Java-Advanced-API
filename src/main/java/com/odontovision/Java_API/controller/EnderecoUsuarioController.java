package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.EnderecoUsuarioDto;
import com.odontovision.Java_API.service.EnderecoUsuarioService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/enderecos-usuario")
@Validated
public class EnderecoUsuarioController {

    private final EnderecoUsuarioService service;

    public EnderecoUsuarioController(EnderecoUsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<EnderecoUsuarioDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(EnderecoUsuarioController.class).buscar(dto.id())).withSelfRel(),
                        linkTo(methodOn(EnderecoUsuarioController.class).listar()).withRel("enderecos-usuario")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(EnderecoUsuarioController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EnderecoUsuarioDto>> buscar(@PathVariable Long id) {
        var dto = service.buscarPorId(id);
        var resource = EntityModel.of(dto,
                linkTo(methodOn(EnderecoUsuarioController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(EnderecoUsuarioController.class).listar()).withRel("enderecos-usuario")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<EnderecoUsuarioDto>> criar(
            @RequestBody @Valid EnderecoUsuarioDto dto
    ) {
        var criado = service.criar(dto.usuarioId(), dto);
        var resource = EntityModel.of(criado,
                linkTo(methodOn(EnderecoUsuarioController.class).buscar(criado.id())).withSelfRel(),
                linkTo(methodOn(EnderecoUsuarioController.class).listar()).withRel("enderecos-usuario")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<EnderecoUsuarioDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid EnderecoUsuarioDto dto
    ) {
        var atualizado = service.atualizar(id, dto.usuarioId(), dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(EnderecoUsuarioController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(EnderecoUsuarioController.class).listar()).withRel("enderecos-usuario")
        );
    }
}