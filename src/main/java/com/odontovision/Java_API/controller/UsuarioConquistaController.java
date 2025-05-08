package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.UsuarioConquistaDto;
import com.odontovision.Java_API.service.UsuarioConquistaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario-conquistas")
public class UsuarioConquistaController {

    private final UsuarioConquistaService service;

    public UsuarioConquistaController(UsuarioConquistaService service) {
        this.service = service;
    }

    @GetMapping
    public List<UsuarioConquistaDto> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{usuarioId}/{conquistaId}")
    public ResponseEntity<UsuarioConquistaDto> buscar(
            @PathVariable Long usuarioId,
            @PathVariable Long conquistaId
    ) {
        UsuarioConquistaDto dto = service.buscarPorId(usuarioId, conquistaId);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<UsuarioConquistaDto> criar(
            @RequestBody @Valid UsuarioConquistaDto dto
    ) {
        UsuarioConquistaDto criado = service.criar(dto);
        URI location = URI.create(
                String.format("/usuario-conquistas/%d/%d", criado.usuarioId(), criado.conquistaId())
        );
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{usuarioId}/{conquistaId}")
    public ResponseEntity<UsuarioConquistaDto> atualizar(
            @PathVariable Long usuarioId,
            @PathVariable Long conquistaId,
            @RequestBody @Valid UsuarioConquistaDto dto
    ) {
        UsuarioConquistaDto atualizado = service.atualizar(usuarioId, conquistaId, dto);
        return ResponseEntity.ok(atualizado);
    }

}