package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.HistoricoTratamentoDto;
import com.odontovision.Java_API.service.HistoricoTratamentoService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/historico-tratamentos")
@Validated
public class HistoricoTratamentoController {

    private final HistoricoTratamentoService service;

    public HistoricoTratamentoController(HistoricoTratamentoService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<HistoricoTratamentoDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(HistoricoTratamentoController.class).buscar(dto.id())).withSelfRel(),
                        linkTo(methodOn(HistoricoTratamentoController.class).listar()).withRel("historico-tratamentos")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(HistoricoTratamentoController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<HistoricoTratamentoDto>> buscar(@PathVariable Long id) {
        var dto = service.buscarPorId(id);
        var resource = EntityModel.of(dto,
                linkTo(methodOn(HistoricoTratamentoController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(HistoricoTratamentoController.class).listar()).withRel("historico-tratamentos")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<HistoricoTratamentoDto>> criar(
            @RequestBody @Valid HistoricoTratamentoDto dto
    ) {
        var criado = service.criar(dto);
        var resource = EntityModel.of(criado,
                linkTo(methodOn(HistoricoTratamentoController.class).buscar(criado.id())).withSelfRel(),
                linkTo(methodOn(HistoricoTratamentoController.class).listar()).withRel("historico-tratamentos")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

}