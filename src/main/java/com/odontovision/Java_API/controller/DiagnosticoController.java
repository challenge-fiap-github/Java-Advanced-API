package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.DiagnosticoRequestDto;
import com.odontovision.Java_API.dto.DiagnosticoResponseDto;
import com.odontovision.Java_API.service.DiagnosticoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/diagnosticos")
public class DiagnosticoController {

    private final DiagnosticoService diagnosticoService;

    public DiagnosticoController(DiagnosticoService diagnosticoService) {
        this.diagnosticoService = diagnosticoService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<DiagnosticoResponseDto>> criarDiagnostico(@RequestBody @Valid DiagnosticoRequestDto diagnosticoRequestDto) {
        DiagnosticoResponseDto novoDiagnostico = diagnosticoService.criarDiagnostico(diagnosticoRequestDto);
        return ResponseEntity.ok(adicionarLinksDiagnostico(novoDiagnostico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<DiagnosticoResponseDto>> atualizarDiagnostico(@PathVariable Long id, @RequestBody @Valid DiagnosticoRequestDto diagnosticoRequestDto) {
        DiagnosticoResponseDto atualizado = diagnosticoService.atualizarDiagnostico(id, diagnosticoRequestDto);
        return ResponseEntity.ok(adicionarLinksDiagnostico(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDiagnostico(@PathVariable Long id) {
        diagnosticoService.deletarDiagnostico(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<DiagnosticoResponseDto>> buscarDiagnosticoPorId(@PathVariable Long id) {
        DiagnosticoResponseDto diagnostico = diagnosticoService.buscarPorId(id);
        return ResponseEntity.ok(adicionarLinksDiagnostico(diagnostico));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<DiagnosticoResponseDto>>> listarTodosDiagnosticos() {
        List<EntityModel<DiagnosticoResponseDto>> diagnosticos = diagnosticoService.listarTodos()
                .stream()
                .map(this::adicionarLinksDiagnostico)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(diagnosticos,
                linkTo(methodOn(DiagnosticoController.class).listarTodosDiagnosticos()).withSelfRel()));
    }

    private EntityModel<DiagnosticoResponseDto> adicionarLinksDiagnostico(DiagnosticoResponseDto diagnosticoDto) {
        return EntityModel.of(diagnosticoDto,
                linkTo(methodOn(DiagnosticoController.class).buscarDiagnosticoPorId(diagnosticoDto.id())).withSelfRel(),
                linkTo(methodOn(DiagnosticoController.class).listarTodosDiagnosticos()).withRel("listar-todos-diagnosticos"));
    }
}
