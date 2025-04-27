package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.RecompensaResponseDto;
import com.odontovision.Java_API.service.RecompensaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recompensas")
public class RecompensaController {

    private final RecompensaService recompensaService;

    public RecompensaController(RecompensaService recompensaService) {
        this.recompensaService = recompensaService;
    }

    @GetMapping
    public ResponseEntity<List<RecompensaResponseDto>> listarRecompensas() {
        List<RecompensaResponseDto> recompensas = recompensaService.listarRecompensas();
        return ResponseEntity.ok(recompensas);
    }
}
