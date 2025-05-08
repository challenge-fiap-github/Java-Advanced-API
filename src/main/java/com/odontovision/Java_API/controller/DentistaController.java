package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.DentistaRequestDto;
import com.odontovision.Java_API.dto.DentistaResponseDto;
import com.odontovision.Java_API.entity.Dentista;
import com.odontovision.Java_API.exception.DentistaNotFoundException;
import com.odontovision.Java_API.mapper.DentistaMapper;
import com.odontovision.Java_API.service.DentistaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/dentistas")
@Validated
public class DentistaController {

    private final DentistaService service;
    private final DentistaMapper mapper;

    public DentistaController(DentistaService service,
                              DentistaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public CollectionModel<EntityModel<DentistaResponseDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(mapper::toResponseDto)
                .map(dto -> EntityModel.of(dto,
                        // agora usamos dto.id() para o self-link
                        linkTo(methodOn(DentistaController.class).buscar(dto.id())).withSelfRel(),
                        linkTo(methodOn(DentistaController.class).listar()).withRel("dentistas")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(DentistaController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<DentistaResponseDto>> buscar(@PathVariable Long id) {
        Dentista d = service.buscarPorId(id)
                .orElseThrow(() -> new DentistaNotFoundException(id));
        DentistaResponseDto dto = mapper.toResponseDto(d);
        EntityModel<DentistaResponseDto> resource = EntityModel.of(dto,
                linkTo(methodOn(DentistaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(DentistaController.class).listar()).withRel("dentistas")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<DentistaResponseDto>> criar(
            @RequestBody @Validated DentistaRequestDto request
    ) {
        Dentista toCreate = mapper.toEntity(request);
        Dentista created = service.criar(toCreate);
        DentistaResponseDto dto = mapper.toResponseDto(created);

        EntityModel<DentistaResponseDto> resource = EntityModel.of(dto,
                linkTo(methodOn(DentistaController.class).buscar(created.getId())).withSelfRel(),
                linkTo(methodOn(DentistaController.class).listar()).withRel("dentistas")
        );

        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<DentistaResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Validated DentistaRequestDto request
    ) {
        Dentista toUpdate = mapper.toEntity(request);
        Dentista updated = service.atualizar(id, toUpdate);
        DentistaResponseDto dto = mapper.toResponseDto(updated);

        return EntityModel.of(dto,
                linkTo(methodOn(DentistaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(DentistaController.class).listar()).withRel("dentistas")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}