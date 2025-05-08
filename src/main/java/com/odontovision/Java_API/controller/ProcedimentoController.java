package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ProcedimentoRequestDto;
import com.odontovision.Java_API.dto.ProcedimentoResponseDto;
import com.odontovision.Java_API.service.ProcedimentoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/procedimentos")
@Validated
public class ProcedimentoController {

    private final ProcedimentoService service;

    public ProcedimentoController(ProcedimentoService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<ProcedimentoResponseDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(ProcedimentoController.class).buscar(dto.getId())).withSelfRel(),
                        linkTo(methodOn(ProcedimentoController.class).listar()).withRel("procedimentos")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(ProcedimentoController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProcedimentoResponseDto>> buscar(@PathVariable Long id) {
        ProcedimentoResponseDto dto = service.buscarPorId(id);
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(ProcedimentoController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(ProcedimentoController.class).listar()).withRel("procedimentos")
        ));
    }

    @PostMapping
    public ResponseEntity<EntityModel<ProcedimentoResponseDto>> criar(
            @RequestBody @Valid ProcedimentoRequestDto dto) {
        ProcedimentoResponseDto criado = service.criar(dto);
        EntityModel<ProcedimentoResponseDto> resource = EntityModel.of(criado,
                linkTo(methodOn(ProcedimentoController.class).buscar(criado.getId())).withSelfRel(),
                linkTo(methodOn(ProcedimentoController.class).listar()).withRel("procedimentos")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<ProcedimentoResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid ProcedimentoRequestDto dto) {
        ProcedimentoResponseDto atualizado = service.atualizar(id, dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(ProcedimentoController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(ProcedimentoController.class).listar()).withRel("procedimentos")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}