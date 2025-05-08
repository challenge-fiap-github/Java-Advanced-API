package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.PlanoProcedimentoDto;
import com.odontovision.Java_API.service.PlanoProcedimentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/planos-procedimento")
public class PlanoProcedimentoController {

    private final PlanoProcedimentoService service;

    public PlanoProcedimentoController(PlanoProcedimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<PlanoProcedimentoDto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{planoId}/{procedimentoId}")
    public ResponseEntity<PlanoProcedimentoDto> buscar(
            @PathVariable Long planoId,
            @PathVariable Long procedimentoId) {

        PlanoProcedimentoDto dto = service.buscarPorId(planoId, procedimentoId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<PlanoProcedimentoDto> criar(
            @RequestBody @Valid PlanoProcedimentoDto dto) {

        PlanoProcedimentoDto criado = service.criar(dto);
        URI location = URI.create(
                String.format("/planos-procedimento/%d/%d",
                        criado.planoId(), criado.procedimentoId())
        );
        return ResponseEntity
                .created(location)
                .body(criado);
    }

    @DeleteMapping("/{planoId}/{procedimentoId}")
    public ResponseEntity<Void> excluir(
            @PathVariable Long planoId,
            @PathVariable Long procedimentoId) {

        service.excluir(planoId, procedimentoId);
        return ResponseEntity.noContent().build();
    }
}