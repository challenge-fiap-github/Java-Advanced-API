package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.DiagnosticoRequestDto;
import com.odontovision.Java_API.dto.DiagnosticoResponseDto;
import com.odontovision.Java_API.service.DiagnosticoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping
    public ResponseEntity<DiagnosticoResponseDto> criarDiagnostico(@RequestBody @Valid DiagnosticoRequestDto diagnosticoRequestDto) {
        DiagnosticoResponseDto novoDiagnostico = diagnosticoService.criarDiagnostico(diagnosticoRequestDto);
        return ResponseEntity.ok(novoDiagnostico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiagnosticoResponseDto> atualizarDiagnostico(@PathVariable Long id, @RequestBody @Valid DiagnosticoRequestDto diagnosticoRequestDto) {
        DiagnosticoResponseDto atualizado = diagnosticoService.atualizarDiagnostico(id, diagnosticoRequestDto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiagnostico(@PathVariable Long id) {
        diagnosticoService.deletarDiagnostico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiagnosticoResponseDto> buscarDiagnosticoPorId(@PathVariable Long id) {
        DiagnosticoResponseDto diagnostico = diagnosticoService.buscarPorId(id);
        return ResponseEntity.ok(diagnostico);
    }

    @GetMapping
    public ResponseEntity<List<DiagnosticoResponseDto>> listarTodosDiagnosticos() {
        List<DiagnosticoResponseDto> diagnosticos = diagnosticoService.listarTodos();
        return ResponseEntity.ok(diagnosticos);
    }
}
