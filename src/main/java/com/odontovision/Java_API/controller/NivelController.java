package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.NivelDto;
import com.odontovision.Java_API.service.NivelService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/niveis")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<NivelDto>>> listarNiveis() {
        List<EntityModel<NivelDto>> niveis = nivelService.listarNiveis()
                .stream()
                .map(this::adicionarLinksNivel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(niveis,
                linkTo(methodOn(NivelController.class).listarNiveis()).withSelfRel()));
    }

    private EntityModel<NivelDto> adicionarLinksNivel(NivelDto nivelDto) {
        return EntityModel.of(nivelDto,
                linkTo(methodOn(NivelController.class).listarNiveis()).withRel("listar-niveis"));
    }
}
