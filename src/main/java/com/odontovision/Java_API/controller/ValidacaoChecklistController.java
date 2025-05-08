package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ValidacaoChecklistDto;
import com.odontovision.Java_API.service.ValidacaoChecklistService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/validacoes-checklist")
@Validated
public class ValidacaoChecklistController {

    private final ValidacaoChecklistService service;

    public ValidacaoChecklistController(ValidacaoChecklistService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<ValidacaoChecklistDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(ValidacaoChecklistController.class).buscar(dto.id())).withSelfRel(),
                        linkTo(methodOn(ValidacaoChecklistController.class).listar()).withRel("validacoes-checklist")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(ValidacaoChecklistController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ValidacaoChecklistDto>> buscar(@PathVariable Long id) {
        var dto = service.buscarPorId(id);
        var resource = EntityModel.of(dto,
                linkTo(methodOn(ValidacaoChecklistController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(ValidacaoChecklistController.class).listar()).withRel("validacoes-checklist")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<ValidacaoChecklistDto>> criar(
            @RequestBody @Valid ValidacaoChecklistDto dto) {

        var criado = service.criar(dto);
        var resource = EntityModel.of(criado,
                linkTo(methodOn(ValidacaoChecklistController.class).buscar(criado.id())).withSelfRel(),
                linkTo(methodOn(ValidacaoChecklistController.class).listar()).withRel("validacoes-checklist")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<ValidacaoChecklistDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ValidacaoChecklistDto dto) {

        var atualizado = service.atualizar(id, dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(ValidacaoChecklistController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(ValidacaoChecklistController.class).listar()).withRel("validacoes-checklist")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}