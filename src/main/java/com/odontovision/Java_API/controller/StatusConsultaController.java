package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.StatusConsultaDto;
import com.odontovision.Java_API.service.StatusConsultaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/status-consultas")
public class StatusConsultaController {

    private final StatusConsultaService statusConsultaService;

    public StatusConsultaController(StatusConsultaService statusConsultaService) {
        this.statusConsultaService = statusConsultaService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<StatusConsultaDto>>> listarStatusConsultas() {
        List<EntityModel<StatusConsultaDto>> statusConsultas = statusConsultaService.listarStatusConsultas()
                .stream()
                .map(this::adicionarLinksStatusConsulta)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(statusConsultas,
                linkTo(methodOn(StatusConsultaController.class).listarStatusConsultas()).withSelfRel()));
    }

    private EntityModel<StatusConsultaDto> adicionarLinksStatusConsulta(StatusConsultaDto statusConsultaDto) {
        return EntityModel.of(statusConsultaDto,
                linkTo(methodOn(StatusConsultaController.class).listarStatusConsultas()).withRel("listar-status-consultas"));
    }
}
