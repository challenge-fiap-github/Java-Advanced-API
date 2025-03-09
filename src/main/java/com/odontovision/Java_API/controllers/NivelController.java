package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Nivel;
import com.odontovision.Java_API.services.NivelService;
import com.odontovision.Java_API.dtos.NivelDTO;
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
@RequestMapping("/niveis")
public class NivelController {

    @Autowired
    private NivelService nivelService;

    @PostMapping
    public ResponseEntity<EntityModel<NivelDTO>> cadastrarNivel(@RequestBody NivelDTO dto) {
        Nivel nivel = nivelService.salvarNivel(dto);
        NivelDTO nivelDTO = new NivelDTO(nivel);

        return ResponseEntity.ok(EntityModel.of(nivelDTO,
                linkTo(methodOn(NivelController.class).buscarNivelPorId(nivel.getId())).withSelfRel(),
                linkTo(methodOn(NivelController.class).listarNiveis()).withRel("niveis")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<NivelDTO>> listarNiveis() {
        List<Nivel> niveis = nivelService.listarNiveis();
        List<NivelDTO> dtos = niveis.stream()
                .map(NivelDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(NivelController.class).listarNiveis()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<NivelDTO>> buscarNivelPorId(@PathVariable Long id) {
        Optional<Nivel> nivel = nivelService.buscarNivelPorId(id);

        return nivel.map(n -> ResponseEntity.ok(EntityModel.of(new NivelDTO(n),
                        linkTo(methodOn(NivelController.class).buscarNivelPorId(id)).withSelfRel(),
                        linkTo(methodOn(NivelController.class).listarNiveis()).withRel("niveis"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirNivel(@PathVariable Long id) {
        nivelService.excluirNivel(id);
        return ResponseEntity.noContent().build();
    }
}