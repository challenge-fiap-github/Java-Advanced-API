package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.NivelDto;
import com.odontovision.Java_API.service.NivelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/niveis")
public class NivelController {

    private final NivelService nivelService;

    public NivelController(NivelService nivelService) {
        this.nivelService = nivelService;
    }

    @GetMapping
    public ResponseEntity<List<NivelDto>> listarNiveis() {
        List<NivelDto> niveis = nivelService.listarNiveis();
        return ResponseEntity.ok(niveis);
    }
}
