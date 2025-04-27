package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ConsultaRequestDto;
import com.odontovision.Java_API.dto.ConsultaResponseDto;
import com.odontovision.Java_API.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<ConsultaResponseDto> criarConsulta(@RequestBody @Valid ConsultaRequestDto consultaRequestDto) {
        ConsultaResponseDto novaConsulta = consultaService.criarConsulta(consultaRequestDto);
        return ResponseEntity.ok(novaConsulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDto> atualizarConsulta(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDto consultaRequestDto) {
        ConsultaResponseDto atualizada = consultaService.atualizarConsulta(id, consultaRequestDto);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDto> buscarConsultaPorId(@PathVariable Long id) {
        ConsultaResponseDto consulta = consultaService.buscarPorId(id);
        return ResponseEntity.ok(consulta);
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDto>> listarTodasConsultas() {
        List<ConsultaResponseDto> consultas = consultaService.listarTodas();
        return ResponseEntity.ok(consultas);
    }
}
