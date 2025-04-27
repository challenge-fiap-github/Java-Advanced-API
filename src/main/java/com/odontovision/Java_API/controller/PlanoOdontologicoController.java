package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.PlanoOdontologicoRequestDto;
import com.odontovision.Java_API.dto.PlanoOdontologicoResponseDto;
import com.odontovision.Java_API.service.PlanoOdontologicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planos")
public class PlanoOdontologicoController {

    private final PlanoOdontologicoService planoService;

    public PlanoOdontologicoController(PlanoOdontologicoService planoService) {
        this.planoService = planoService;
    }

    @PostMapping
    public ResponseEntity<PlanoOdontologicoResponseDto> criarPlano(@RequestBody @Valid PlanoOdontologicoRequestDto planoRequestDto) {
        PlanoOdontologicoResponseDto novoPlano = planoService.criarPlano(planoRequestDto);
        return ResponseEntity.ok(novoPlano);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlanoOdontologicoResponseDto> atualizarPlano(@PathVariable Long id, @RequestBody @Valid PlanoOdontologicoRequestDto planoRequestDto) {
        PlanoOdontologicoResponseDto atualizado = planoService.atualizarPlano(id, planoRequestDto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlanoOdontologicoResponseDto> buscarPlanoPorId(@PathVariable Long id) {
        PlanoOdontologicoResponseDto plano = planoService.buscarPorId(id);
        return ResponseEntity.ok(plano);
    }

    @GetMapping
    public ResponseEntity<List<PlanoOdontologicoResponseDto>> listarTodosPlanos() {
        List<PlanoOdontologicoResponseDto> planos = planoService.listarTodos();
        return ResponseEntity.ok(planos);
    }
}
