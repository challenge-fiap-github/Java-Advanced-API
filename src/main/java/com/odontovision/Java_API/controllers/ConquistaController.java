package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Conquista;
import com.odontovision.Java_API.services.ConquistaService;
import com.odontovision.Java_API.dtos.ConquistaDTO;
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
@RequestMapping("/conquistas")
public class ConquistaController {

    @Autowired
    private ConquistaService conquistaService;

    @PostMapping
    public ResponseEntity<EntityModel<ConquistaDTO>> cadastrarConquista(@RequestBody ConquistaDTO dto) {
        Conquista conquista = conquistaService.cadastrarConquista(dto);
        ConquistaDTO conquistaDTO = new ConquistaDTO(conquista);

        return ResponseEntity.ok(EntityModel.of(conquistaDTO,
                linkTo(methodOn(ConquistaController.class).buscarConquistaPorId(conquista.getId())).withSelfRel(),
                linkTo(methodOn(ConquistaController.class).listarConquistas()).withRel("conquistas")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ConquistaDTO>> listarConquistas() {
        List<Conquista> conquistas = conquistaService.listarConquistas();
        List<ConquistaDTO> dtos = conquistas.stream()
                .map(ConquistaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(ConquistaController.class).listarConquistas()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ConquistaDTO>> buscarConquistaPorId(@PathVariable Long id) {
        Optional<Conquista> conquista = conquistaService.buscarConquistaPorId(id);

        return conquista.map(c -> ResponseEntity.ok(EntityModel.of(new ConquistaDTO(c),
                        linkTo(methodOn(ConquistaController.class).buscarConquistaPorId(id)).withSelfRel(),
                        linkTo(methodOn(ConquistaController.class).listarConquistas()).withRel("conquistas"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirConquista(@PathVariable Long id) {
        conquistaService.excluirConquista(id);
        return ResponseEntity.noContent().build();
    }
}