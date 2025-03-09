package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Dentista;
import com.odontovision.Java_API.services.DentistaService;
import com.odontovision.Java_API.dtos.DentistaDTO;
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
@RequestMapping("/dentistas")
public class DentistaController {

    @Autowired
    private DentistaService dentistaService;

    @PostMapping
    public ResponseEntity<EntityModel<DentistaDTO>> cadastrarDentista(@RequestBody DentistaDTO dto) {
        Dentista dentista = dentistaService.cadastrarDentista(dto);
        DentistaDTO dentistaDTO = new DentistaDTO(dentista);

        return ResponseEntity.ok(EntityModel.of(dentistaDTO,
                linkTo(methodOn(DentistaController.class).buscarDentistaPorId(dentista.getId())).withSelfRel(),
                linkTo(methodOn(DentistaController.class).listarDentistas()).withRel("dentistas")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<DentistaDTO>> listarDentistas() {
        List<Dentista> dentistas = dentistaService.listarDentistas();
        List<DentistaDTO> dtos = dentistas.stream()
                .map(DentistaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(DentistaController.class).listarDentistas()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<DentistaDTO>> buscarDentistaPorId(@PathVariable Long id) {
        Optional<Dentista> dentista = dentistaService.buscarPorId(id);

        return dentista.map(d -> ResponseEntity.ok(EntityModel.of(new DentistaDTO(d),
                        linkTo(methodOn(DentistaController.class).buscarDentistaPorId(id)).withSelfRel(),
                        linkTo(methodOn(DentistaController.class).listarDentistas()).withRel("dentistas"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirDentista(@PathVariable Long id) {
        dentistaService.excluirDentista(id);
        return ResponseEntity.noContent().build();
    }
}