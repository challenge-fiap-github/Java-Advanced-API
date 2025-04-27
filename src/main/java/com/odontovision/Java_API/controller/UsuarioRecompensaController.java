package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.UsuarioRecompensaDto;
import com.odontovision.Java_API.service.UsuarioRecompensaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario-recompensas")
public class UsuarioRecompensaController {

    private final UsuarioRecompensaService usuarioRecompensaService;

    public UsuarioRecompensaController(UsuarioRecompensaService usuarioRecompensaService) {
        this.usuarioRecompensaService = usuarioRecompensaService;
    }

    @PostMapping
    public ResponseEntity<UsuarioRecompensaDto> criar(@RequestBody @Valid UsuarioRecompensaDto dto) {
        UsuarioRecompensaDto novo = usuarioRecompensaService.criarUsuarioRecompensa(dto);
        return ResponseEntity.ok(novo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioRecompensaService.deletarUsuarioRecompensa(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRecompensaDto> buscarPorId(@PathVariable Long id) {
        UsuarioRecompensaDto encontrado = usuarioRecompensaService.buscarPorId(id);
        return ResponseEntity.ok(encontrado);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioRecompensaDto>> listarTodos() {
        List<UsuarioRecompensaDto> lista = usuarioRecompensaService.listarTodos();
        return ResponseEntity.ok(lista);
    }
}
