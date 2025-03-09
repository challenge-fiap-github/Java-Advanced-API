package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.PlanoOdontologico;
import com.odontovision.Java_API.services.PlanoOdontologicoService;
import com.odontovision.Java_API.dtos.PlanoOdontologicoDTO;
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
@RequestMapping("/planos-odontologicos")
public class PlanoOdontologicoController {

    @Autowired
    private PlanoOdontologicoService planoOdontologicoService;

    @PostMapping
    public ResponseEntity<EntityModel<PlanoOdontologicoDTO>> cadastrarPlano(@RequestBody PlanoOdontologicoDTO dto) {
        PlanoOdontologico plano = planoOdontologicoService.salvarPlano(dto);
        PlanoOdontologicoDTO planoDTO = new PlanoOdontologicoDTO(plano);

        return ResponseEntity.ok(EntityModel.of(planoDTO,
                linkTo(methodOn(PlanoOdontologicoController.class).buscarPlanoPorId(plano.getId())).withSelfRel(),
                linkTo(methodOn(PlanoOdontologicoController.class).listarPlanos()).withRel("planos-odontologicos")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<PlanoOdontologicoDTO>> listarPlanos() {
        List<PlanoOdontologico> planos = planoOdontologicoService.listarPlanos();
        List<PlanoOdontologicoDTO> dtos = planos.stream()
                .map(PlanoOdontologicoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(PlanoOdontologicoController.class).listarPlanos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PlanoOdontologicoDTO>> buscarPlanoPorId(@PathVariable Long id) {
        Optional<PlanoOdontologico> plano = planoOdontologicoService.buscarPlanoPorId(id);

        return plano.map(p -> ResponseEntity.ok(EntityModel.of(new PlanoOdontologicoDTO(p),
                        linkTo(methodOn(PlanoOdontologicoController.class).buscarPlanoPorId(id)).withSelfRel(),
                        linkTo(methodOn(PlanoOdontologicoController.class).listarPlanos()).withRel("planos-odontologicos"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPlano(@PathVariable Long id) {
        planoOdontologicoService.excluirPlano(id);
        return ResponseEntity.noContent().build();
    }
}
