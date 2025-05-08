package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.PlanoCoberturaDto;
import com.odontovision.Java_API.service.PlanoCoberturaService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/planos-cobertura")
public class PlanoCoberturaController {

    private final PlanoCoberturaService service;

    public PlanoCoberturaController(PlanoCoberturaService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<PlanoCoberturaDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(PlanoCoberturaController.class).buscar(dto.id())).withSelfRel(),
                        linkTo(methodOn(PlanoCoberturaController.class).listar()).withRel("planos-cobertura")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(PlanoCoberturaController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PlanoCoberturaDto>> buscar(@PathVariable Long id) {
        var dto = service.buscarPorId(id);
        var resource = EntityModel.of(dto,
                linkTo(methodOn(PlanoCoberturaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(PlanoCoberturaController.class).listar()).withRel("planos-cobertura")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<PlanoCoberturaDto>> criar(
            @RequestBody @Valid PlanoCoberturaDto dto) {

        var criado = service.criar(dto);
        var resource = EntityModel.of(criado,
                linkTo(methodOn(PlanoCoberturaController.class).buscar(criado.id())).withSelfRel(),
                linkTo(methodOn(PlanoCoberturaController.class).listar()).withRel("planos-cobertura")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<PlanoCoberturaDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid PlanoCoberturaDto dto) {

        var atualizado = service.atualizar(id, dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(PlanoCoberturaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(PlanoCoberturaController.class).listar()).withRel("planos-cobertura")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}