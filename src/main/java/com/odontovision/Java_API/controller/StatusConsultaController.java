package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.StatusConsultaDto;
import com.odontovision.Java_API.service.StatusConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/status-consultas")
public class StatusConsultaController {

    private final StatusConsultaService statusConsultaService;

    public StatusConsultaController(StatusConsultaService statusConsultaService) {
        this.statusConsultaService = statusConsultaService;
    }

    @GetMapping
    public ResponseEntity<List<StatusConsultaDto>> listarStatusConsultas() {
        List<StatusConsultaDto> statusConsultas = statusConsultaService.listarStatusConsultas();
        return ResponseEntity.ok(statusConsultas);
    }
}
