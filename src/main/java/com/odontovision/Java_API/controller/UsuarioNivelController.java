package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.UsuarioNivelDto;
import com.odontovision.Java_API.service.UsuarioNivelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario-niveis")
public class UsuarioNivelController {

    private final UsuarioNivelService service;

    public UsuarioNivelController(UsuarioNivelService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioNivelDto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{usuarioId}/{nivelId}")
    public ResponseEntity<UsuarioNivelDto> buscar(
            @PathVariable Long usuarioId,
            @PathVariable Long nivelId
    ) {
        var dto = service.buscarPorId(usuarioId, nivelId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioNivelDto> criar(
            @RequestBody @Valid UsuarioNivelDto dto
    ) {
        var criado = service.criar(dto);
        URI location = URI.create(
                String.format("/usuario-niveis/%d/%d", criado.usuarioId(), criado.nivelId())
        );
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{usuarioId}/{nivelId}")
    public ResponseEntity<UsuarioNivelDto> atualizar(
            @PathVariable Long usuarioId,
            @PathVariable Long nivelId,
            @RequestBody @Valid UsuarioNivelDto dto
    ) {
        var atualizado = service.atualizar(usuarioId, nivelId, dto);
        return ResponseEntity.ok(atualizado);
    }

}