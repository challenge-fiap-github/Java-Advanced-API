package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Recompensa;
import com.odontovision.Java_API.services.RecompensaService;
import com.odontovision.Java_API.dtos.RecompensaDTO;
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
@RequestMapping("/recompensas")
public class RecompensaController {

    @Autowired
    private RecompensaService recompensaService;

    @PostMapping
    public ResponseEntity<EntityModel<RecompensaDTO>> cadastrarRecompensa(@RequestBody RecompensaDTO dto) {
        Recompensa recompensa = recompensaService.salvarRecompensa(dto);
        RecompensaDTO recompensaDTO = new RecompensaDTO(recompensa);

        return ResponseEntity.ok(EntityModel.of(recompensaDTO,
                linkTo(methodOn(RecompensaController.class).buscarRecompensaPorId(recompensa.getId())).withSelfRel(),
                linkTo(methodOn(RecompensaController.class).listarRecompensas()).withRel("recompensas")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<RecompensaDTO>> listarRecompensas() {
        List<Recompensa> recompensas = recompensaService.listarRecompensas();
        List<RecompensaDTO> dtos = recompensas.stream()
                .map(RecompensaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(RecompensaController.class).listarRecompensas()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<RecompensaDTO>> buscarRecompensaPorId(@PathVariable Long id) {
        Optional<Recompensa> recompensa = recompensaService.buscarRecompensaPorId(id);

        return recompensa.map(r -> ResponseEntity.ok(EntityModel.of(new RecompensaDTO(r),
                        linkTo(methodOn(RecompensaController.class).buscarRecompensaPorId(id)).withSelfRel(),
                        linkTo(methodOn(RecompensaController.class).listarRecompensas()).withRel("recompensas"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirRecompensa(@PathVariable Long id) {
        recompensaService.excluirRecompensa(id);
        return ResponseEntity.noContent().build();
    }
}