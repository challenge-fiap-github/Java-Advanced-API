package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.ChecklistDiario;
import com.odontovision.Java_API.services.ChecklistDiarioService;
import com.odontovision.Java_API.dtos.ChecklistDiarioDTO;
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
@RequestMapping("/checklists")
public class ChecklistDiarioController {

    @Autowired
    private ChecklistDiarioService checklistDiarioService;

    @PostMapping
    public ResponseEntity<EntityModel<ChecklistDiarioDTO>> registrarChecklist(@RequestBody ChecklistDiarioDTO dto) {
        ChecklistDiario checklist = checklistDiarioService.registrarChecklist(dto);
        ChecklistDiarioDTO checklistDTO = new ChecklistDiarioDTO(checklist);

        return ResponseEntity.ok(EntityModel.of(checklistDTO,
                linkTo(methodOn(ChecklistDiarioController.class).buscarChecklistPorId(checklist.getId())).withSelfRel(),
                linkTo(methodOn(ChecklistDiarioController.class).listarChecklists()).withRel("checklists")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ChecklistDiarioDTO>> listarChecklists() {
        List<ChecklistDiario> checklists = checklistDiarioService.listarChecklists();
        List<ChecklistDiarioDTO> dtos = checklists.stream()
                .map(ChecklistDiarioDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(ChecklistDiarioController.class).listarChecklists()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ChecklistDiarioDTO>> buscarChecklistPorId(@PathVariable Long id) {
        Optional<ChecklistDiario> checklist = checklistDiarioService.buscarChecklistPorId(id);

        return checklist.map(c -> ResponseEntity.ok(EntityModel.of(new ChecklistDiarioDTO(c),
                        linkTo(methodOn(ChecklistDiarioController.class).buscarChecklistPorId(id)).withSelfRel(),
                        linkTo(methodOn(ChecklistDiarioController.class).listarChecklists()).withRel("checklists"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirChecklist(@PathVariable Long id) {
        checklistDiarioService.excluirChecklist(id);
        return ResponseEntity.noContent().build();
    }
}