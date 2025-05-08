package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.HistoricoPontuacaoDto;
import com.odontovision.Java_API.service.HistoricoPontuacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/historicos-pontuacao")
public class HistoricoPontuacaoController {

    private final HistoricoPontuacaoService service;

    public HistoricoPontuacaoController(HistoricoPontuacaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<HistoricoPontuacaoDto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistoricoPontuacaoDto> buscar(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<HistoricoPontuacaoDto> criar(
            @RequestBody @Valid HistoricoPontuacaoDto dto) {
        HistoricoPontuacaoDto criado = service.criar(dto);
        return ResponseEntity
                .created(URI.create("/historicos-pontuacao/" + criado.id()))
                .body(criado);
    }

}