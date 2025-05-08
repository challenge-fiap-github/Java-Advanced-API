package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.EnderecoClinicaDto;
import com.odontovision.Java_API.service.EnderecoClinicaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/enderecos-clinica")
@Validated
public class EnderecoClinicaController {

    private final EnderecoClinicaService service;

    public EnderecoClinicaController(EnderecoClinicaService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<EnderecoClinicaDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(EnderecoClinicaController.class).buscar(dto.id())).withSelfRel(),
                        linkTo(methodOn(EnderecoClinicaController.class).listar()).withRel("enderecos-clinica")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(EnderecoClinicaController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EnderecoClinicaDto>> buscar(@PathVariable Long id) {
        var dto = service.buscarPorId(id);
        var resource = EntityModel.of(dto,
                linkTo(methodOn(EnderecoClinicaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(EnderecoClinicaController.class).listar()).withRel("enderecos-clinica")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<EnderecoClinicaDto>> criar(
            @RequestBody @Valid EnderecoClinicaDto dto
    ) {
        var criado = service.criar(dto);
        var resource = EntityModel.of(criado,
                linkTo(methodOn(EnderecoClinicaController.class).buscar(criado.id())).withSelfRel(),
                linkTo(methodOn(EnderecoClinicaController.class).listar()).withRel("enderecos-clinica")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<EnderecoClinicaDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid EnderecoClinicaDto dto
    ) {
        var atualizado = service.atualizar(id, dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(EnderecoClinicaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(EnderecoClinicaController.class).listar()).withRel("enderecos-clinica")
        );
    }
}