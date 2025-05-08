package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.EnderecoClinicaDto;
import com.odontovision.Java_API.entity.EnderecoClinica;
import com.odontovision.Java_API.entity.Dentista;
import com.odontovision.Java_API.mapper.EnderecoClinicaMapper;
import com.odontovision.Java_API.service.EnderecoClinicaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/enderecos-clinica")
@Validated
public class EnderecoClinicaController {

    private final EnderecoClinicaService service;
    private final EnderecoClinicaMapper mapper;

    public EnderecoClinicaController(EnderecoClinicaService service,
                                     EnderecoClinicaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public CollectionModel<EntityModel<EnderecoClinicaDto>> listar() {
        var recursos = service.listarTodos().stream()
                .map(mapper::toDto)
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
        EnderecoClinica e = service.buscarPorId(id);
        EnderecoClinicaDto dto = mapper.toDto(e);
        EntityModel<EnderecoClinicaDto> resource = EntityModel.of(dto,
                linkTo(methodOn(EnderecoClinicaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(EnderecoClinicaController.class).listar()).withRel("enderecos-clinica")
        );
        return ResponseEntity.ok(resource);
    }

    @PostMapping
    public ResponseEntity<EntityModel<EnderecoClinicaDto>> criar(
            @RequestBody @Validated EnderecoClinicaDto request
    ) {
        // resolve o dentista associado
        Dentista d = service.lookupDentista(request.dentistaId());
        EnderecoClinica toCreate = mapper.toEntity(request, d);
        EnderecoClinica created = service.criar(toCreate);
        EnderecoClinicaDto dto = mapper.toDto(created);

        EntityModel<EnderecoClinicaDto> resource = EntityModel.of(dto,
                linkTo(methodOn(EnderecoClinicaController.class).buscar(dto.id())).withSelfRel(),
                linkTo(methodOn(EnderecoClinicaController.class).listar()).withRel("enderecos-clinica")
        );

        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<EnderecoClinicaDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Validated EnderecoClinicaDto request
    ) {
        Dentista d = service.lookupDentista(request.dentistaId());
        EnderecoClinica toUpdate = mapper.toEntity(request, d);
        EnderecoClinica updated = service.atualizar(id, toUpdate);
        EnderecoClinicaDto dto = mapper.toDto(updated);

        return EntityModel.of(dto,
                linkTo(methodOn(EnderecoClinicaController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(EnderecoClinicaController.class).listar()).withRel("enderecos-clinica")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}