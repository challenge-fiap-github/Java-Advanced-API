package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.NotificacaoRequestDto;
import com.odontovision.Java_API.dto.NotificacaoResponseDto;
import com.odontovision.Java_API.service.NotificacaoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/notificacoes")
@Validated
public class NotificacaoController {

    private final NotificacaoService service;

    public NotificacaoController(NotificacaoService service) {
        this.service = service;
    }

    @GetMapping
    public CollectionModel<EntityModel<NotificacaoResponseDto>> listar() {
        var recursos = service.listarTodas().stream()
                .map(dto -> EntityModel.of(dto,
                        linkTo(methodOn(NotificacaoController.class).buscar(dto.getId())).withSelfRel(),
                        linkTo(methodOn(NotificacaoController.class).listar()).withRel("notificacoes")
                ))
                .toList();

        return CollectionModel.of(recursos,
                linkTo(methodOn(NotificacaoController.class).listar()).withSelfRel()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<NotificacaoResponseDto>> buscar(@PathVariable Long id) {
        NotificacaoResponseDto dto = service.buscarPorId(id);
        return ResponseEntity.ok(EntityModel.of(dto,
                linkTo(methodOn(NotificacaoController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(NotificacaoController.class).listar()).withRel("notificacoes")
        ));
    }

    @PostMapping
    public ResponseEntity<EntityModel<NotificacaoResponseDto>> criar(
            @RequestBody @Valid NotificacaoRequestDto dto
    ) {
        NotificacaoResponseDto criado = service.criar(dto);
        EntityModel<NotificacaoResponseDto> resource = EntityModel.of(criado,
                linkTo(methodOn(NotificacaoController.class).buscar(criado.getId())).withSelfRel(),
                linkTo(methodOn(NotificacaoController.class).listar()).withRel("notificacoes")
        );
        return ResponseEntity
                .created(URI.create(resource.getRequiredLink("self").getHref()))
                .body(resource);
    }

    @PutMapping("/{id}")
    public EntityModel<NotificacaoResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid NotificacaoRequestDto dto
    ) {
        NotificacaoResponseDto atualizado = service.atualizar(id, dto);
        return EntityModel.of(atualizado,
                linkTo(methodOn(NotificacaoController.class).buscar(id)).withSelfRel(),
                linkTo(methodOn(NotificacaoController.class).listar()).withRel("notificacoes")
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}