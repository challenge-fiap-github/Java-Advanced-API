package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ConquistaDto;
import com.odontovision.Java_API.service.ConquistaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/conquistas")
public class ConquistaController {

    private final ConquistaService conquistaService;

    public ConquistaController(ConquistaService conquistaService) {
        this.conquistaService = conquistaService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ConquistaDto>>> listarConquistas() {
        List<EntityModel<ConquistaDto>> conquistas = conquistaService.listarConquistas()
                .stream()
                .map(this::adicionarLinksConquista)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(conquistas,
                linkTo(methodOn(ConquistaController.class).listarConquistas()).withSelfRel()));
    }

    private EntityModel<ConquistaDto> adicionarLinksConquista(ConquistaDto conquistaDto) {
        return EntityModel.of(conquistaDto,
                linkTo(methodOn(ConquistaController.class).listarConquistas()).withRel("listar-conquistas"));
    }
}
