package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.PontuacaoResponseDto;
import com.odontovision.Java_API.service.PontuacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pontuacoes")
public class PontuacaoController {

    private final PontuacaoService pontuacaoService;

    public PontuacaoController(PontuacaoService pontuacaoService) {
        this.pontuacaoService = pontuacaoService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<PontuacaoResponseDto>> listarPontuacoesPorUsuario(@PathVariable Long usuarioId) {
        List<PontuacaoResponseDto> pontuacoes = pontuacaoService.listarPontuacoesPorUsuario(usuarioId);
        return ResponseEntity.ok(pontuacoes);
    }

    @GetMapping
    public ResponseEntity<List<PontuacaoResponseDto>> listarTodasPontuacoes() {
        List<PontuacaoResponseDto> pontuacoes = pontuacaoService.listarTodasPontuacoes();
        return ResponseEntity.ok(pontuacoes);
    }
}
