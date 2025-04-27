package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.TipoConsultaDto;
import com.odontovision.Java_API.service.TipoConsultaService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/tipos-consulta")
public class TipoConsultaController {

    private final TipoConsultaService tipoConsultaService;

    public TipoConsultaController(TipoConsultaService tipoConsultaService) {
        this.tipoConsultaService = tipoConsultaService;
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<TipoConsultaDto>>> listarTiposConsulta() {
        List<EntityModel<TipoConsultaDto>> tiposConsulta = tipoConsultaService.listarTiposConsulta()
                .stream()
                .map(this::adicionarLinksTipoConsulta)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(tiposConsulta,
                linkTo(methodOn(TipoConsultaController.class).listarTiposConsulta()).withSelfRel()));
    }

    private EntityModel<TipoConsultaDto> adicionarLinksTipoConsulta(TipoConsultaDto tipoConsultaDto) {
        return EntityModel.of(tipoConsultaDto,
                linkTo(methodOn(TipoConsultaController.class).listarTiposConsulta()).withRel("listar-tipos-consulta"));
    }
}
