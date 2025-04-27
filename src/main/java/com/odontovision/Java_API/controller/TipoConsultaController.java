package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.TipoConsultaDto;
import com.odontovision.Java_API.service.TipoConsultaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tipos-consulta")
public class TipoConsultaController {

    private final TipoConsultaService tipoConsultaService;

    public TipoConsultaController(TipoConsultaService tipoConsultaService) {
        this.tipoConsultaService = tipoConsultaService;
    }

    @GetMapping
    public ResponseEntity<List<TipoConsultaDto>> listarTiposConsulta() {
        List<TipoConsultaDto> tiposConsulta = tipoConsultaService.listarTiposConsulta();
        return ResponseEntity.ok(tiposConsulta);
    }
}
