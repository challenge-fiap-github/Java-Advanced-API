package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.AuditoriaDto;
import com.odontovision.Java_API.entity.Auditoria;
import com.odontovision.Java_API.mapper.AuditoriaMapper;
import com.odontovision.Java_API.service.AuditoriaService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/auditorias")
@Validated
public class AuditoriaController {

    private final AuditoriaService service;
    private final AuditoriaMapper mapper;

    public AuditoriaController(AuditoriaService service,
                               AuditoriaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public CollectionModel<EntityModel<AuditoriaDto>> listar() {
        var recursos = service.listarTodas().stream()
                .map(mapper::toDto)
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(AuditoriaController.class).buscar(dto.id())).withSelfRel(),
                        linkTo(methodOn(AuditoriaController.class).listar()).withRel("auditorias")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(AuditoriaController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AuditoriaDto>> buscar(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(mapper::toDto)
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(AuditoriaController.class).buscar(id)).withSelfRel(),
                        linkTo(methodOn(AuditoriaController.class).listar()).withRel("auditorias")
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EntityModel<AuditoriaDto>> criar(
            @RequestBody @Valid AuditoriaDto dto
    ) {
        Auditoria entidade = mapper.toEntity(dto);
        Auditoria criado = service.criar(entidade);
        AuditoriaDto criadoDto = mapper.toDto(criado);

        EntityModel<AuditoriaDto> resource = EntityModel.of(criadoDto,
                linkTo(methodOn(AuditoriaController.class).buscar(criadoDto.id())).withSelfRel(),
                linkTo(methodOn(AuditoriaController.class).listar()).withRel("auditorias")
        );

        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }
}