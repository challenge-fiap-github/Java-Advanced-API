package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ConsultaProcedimentoDto;
import com.odontovision.Java_API.service.ConsultaProcedimentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/consulta-procedimentos")
public class ConsultaProcedimentoController {

    private final ConsultaProcedimentoService service;

    public ConsultaProcedimentoController(ConsultaProcedimentoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ConsultaProcedimentoDto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{consultaId}/{procedimentoId}")
    public ResponseEntity<ConsultaProcedimentoDto> buscar(
            @PathVariable Long consultaId,
            @PathVariable Long procedimentoId
    ) {
        return ResponseEntity.ok(
                service.buscarPorId(consultaId, procedimentoId)
        );
    }

    @PostMapping
    public ResponseEntity<ConsultaProcedimentoDto> criar(
            @RequestBody @Valid ConsultaProcedimentoDto dto
    ) {
        var criado = service.criar(dto);
        URI location = URI.create(
                String.format("/consulta-procedimentos/%d/%d",
                        criado.consultaId(), criado.procedimentoId())
        );
        return ResponseEntity.created(location).body(criado);
    }

}