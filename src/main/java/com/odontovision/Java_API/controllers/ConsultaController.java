package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Consulta;
import com.odontovision.Java_API.services.ConsultaService;
import com.odontovision.Java_API.dtos.ConsultaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<EntityModel<ConsultaDTO>> agendarConsulta(@RequestBody ConsultaDTO dto) {
        Consulta consulta = consultaService.agendarConsulta(dto);
        ConsultaDTO consultaDTO = new ConsultaDTO(consulta);

        return ResponseEntity.ok(EntityModel.of(consultaDTO,
                linkTo(methodOn(ConsultaController.class).buscarConsultaPorId(consulta.getId())).withSelfRel(),
                linkTo(methodOn(ConsultaController.class).listarConsultas()).withRel("consultas")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ConsultaDTO>> listarConsultas() {
        List<Consulta> consultas = consultaService.listarConsultas();
        List<ConsultaDTO> dtos = consultas.stream()
                .map(ConsultaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(ConsultaController.class).listarConsultas()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ConsultaDTO>> buscarConsultaPorId(@PathVariable Long id) {
        Optional<Consulta> consulta = consultaService.buscarConsultaPorId(id);

        return consulta.map(c -> ResponseEntity.ok(EntityModel.of(new ConsultaDTO(c),
                        linkTo(methodOn(ConsultaController.class).buscarConsultaPorId(id)).withSelfRel(),
                        linkTo(methodOn(ConsultaController.class).listarConsultas()).withRel("consultas"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarConsulta(@PathVariable Long id) {
        consultaService.cancelarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}
