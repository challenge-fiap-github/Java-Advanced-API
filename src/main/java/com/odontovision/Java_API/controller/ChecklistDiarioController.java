package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ChecklistDiarioDto;
import com.odontovision.Java_API.service.ChecklistDiarioService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/checklists")
public class ChecklistDiarioController {

    private final ChecklistDiarioService checklistService;

    public ChecklistDiarioController(ChecklistDiarioService checklistService) {
        this.checklistService = checklistService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ChecklistDiarioDto>> criarChecklist(@RequestBody @Valid ChecklistDiarioDto checklistDiarioDto) {
        ChecklistDiarioDto novoChecklist = checklistService.criarChecklist(checklistDiarioDto);
        return ResponseEntity.ok(adicionarLinksChecklist(novoChecklist));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ChecklistDiarioDto>> atualizarChecklist(@PathVariable Long id, @RequestBody @Valid ChecklistDiarioDto checklistDiarioDto) {
        ChecklistDiarioDto atualizado = checklistService.atualizarChecklist(id, checklistDiarioDto);
        return ResponseEntity.ok(adicionarLinksChecklist(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarChecklist(@PathVariable Long id) {
        checklistService.deletarChecklist(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ChecklistDiarioDto>> buscarChecklistPorId(@PathVariable Long id) {
        ChecklistDiarioDto checklist = checklistService.buscarPorId(id);
        return ResponseEntity.ok(adicionarLinksChecklist(checklist));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ChecklistDiarioDto>>> listarTodosChecklists() {
        List<EntityModel<ChecklistDiarioDto>> checklists = checklistService.listarTodos()
                .stream()
                .map(this::adicionarLinksChecklist)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(checklists,
                linkTo(methodOn(ChecklistDiarioController.class).listarTodosChecklists()).withSelfRel()));
    }

    private EntityModel<ChecklistDiarioDto> adicionarLinksChecklist(ChecklistDiarioDto checklistDto) {
        return EntityModel.of(checklistDto,
                linkTo(methodOn(ChecklistDiarioController.class).listarTodosChecklists()).withRel("listar-todos-checklists"));
    }
}
