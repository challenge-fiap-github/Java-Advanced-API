package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.SinistroRequestDto;
import com.odontovision.Java_API.dto.SinistroResponseDto;
import com.odontovision.Java_API.service.SinistroService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/sinistros")
@Validated
public class SinistroController {

    private final SinistroService service;

    public SinistroController(SinistroService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<SinistroResponseDto>> listar() {
        List<EntityModel<SinistroResponseDto>> recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(SinistroController.class).buscar(dto.getId())).withSelfRel(),
                        linkTo(methodOn(SinistroController.class).listar()).withRel("sinistros")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(SinistroController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<SinistroResponseDto>> buscar(@PathVariable Long id) {
        SinistroResponseDto dto = service.buscarPorId(id);
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(SinistroController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(SinistroController.class).listar()).withRel("sinistros")
        ));
    }

    @PostMapping
    public ResponseEntity<EntityModel<SinistroResponseDto>> criar(
            @RequestBody @Valid SinistroRequestDto dto
    ) {
        SinistroResponseDto criado = service.criar(dto);
        EntityModel<SinistroResponseDto> resource = EntityModel.of(criado,
                linkTo(methodOn(SinistroController.class).buscar(criado.getId())).withSelfRel(),
                linkTo(methodOn(SinistroController.class).listar()).withRel("sinistros")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<SinistroResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid SinistroRequestDto dto
    ) {
        SinistroResponseDto atualizado = service.atualizar(id, dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(SinistroController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(SinistroController.class).listar()).withRel("sinistros")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}