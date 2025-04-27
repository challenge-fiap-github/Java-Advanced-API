package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ChecklistDiarioDto;
import com.odontovision.Java_API.service.ChecklistDiarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checklists")
public class ChecklistDiarioController {

    private final ChecklistDiarioService checklistService;

    public ChecklistDiarioController(ChecklistDiarioService checklistService) {
        this.checklistService = checklistService;
    }

    @PostMapping
    public ResponseEntity<ChecklistDiarioDto> criarChecklist(@RequestBody @Valid ChecklistDiarioDto checklistDiarioDto) {
        ChecklistDiarioDto novoChecklist = checklistService.criarChecklist(checklistDiarioDto);
        return ResponseEntity.ok(novoChecklist);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChecklistDiarioDto> atualizarChecklist(@PathVariable Long id, @RequestBody @Valid ChecklistDiarioDto checklistDiarioDto) {
        ChecklistDiarioDto atualizado = checklistService.atualizarChecklist(id, checklistDiarioDto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarChecklist(@PathVariable Long id) {
        checklistService.deletarChecklist(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChecklistDiarioDto> buscarChecklistPorId(@PathVariable Long id) {
        ChecklistDiarioDto checklist = checklistService.buscarPorId(id);
        return ResponseEntity.ok(checklist);
    }

    @GetMapping
    public ResponseEntity<List<ChecklistDiarioDto>> listarTodosChecklists() {
        List<ChecklistDiarioDto> checklists = checklistService.listarTodos();
        return ResponseEntity.ok(checklists);
    }
}
