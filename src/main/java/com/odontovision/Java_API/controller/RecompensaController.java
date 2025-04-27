package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.RecompensaResponseDto;
import com.odontovision.Java_API.service.RecompensaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/recompensas")
public class RecompensaController {

    private final RecompensaService recompensaService;

    public RecompensaController(RecompensaService recompensaService) {
        this.recompensaService = recompensaService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<RecompensaResponseDto>>> listarRecompensas() {
        List<EntityModel<RecompensaResponseDto>> recompensas = recompensaService.listarRecompensas()
                .stream()
                .map(this::adicionarLinksRecompensa)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(recompensas,
                linkTo(methodOn(RecompensaController.class).listarRecompensas()).withSelfRel()));
    }

    private EntityModel<RecompensaResponseDto> adicionarLinksRecompensa(RecompensaResponseDto recompensaDto) {
        return EntityModel.of(recompensaDto,
                linkTo(methodOn(RecompensaController.class).listarRecompensas()).withRel("listar-recompensas"));
    }
}
