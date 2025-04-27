package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ConquistaDto;
import com.odontovision.Java_API.service.ConquistaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conquistas")
public class ConquistaController {

    private final ConquistaService conquistaService;

    public ConquistaController(ConquistaService conquistaService) {
        this.conquistaService = conquistaService;
    }

    @GetMapping
    public ResponseEntity<List<ConquistaDto>> listarConquistas() {
        List<ConquistaDto> conquistas = conquistaService.listarConquistas();
        return ResponseEntity.ok(conquistas);
    }
}
