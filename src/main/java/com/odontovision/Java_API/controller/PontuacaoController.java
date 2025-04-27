package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.PontuacaoResponseDto;
import com.odontovision.Java_API.service.PontuacaoService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/pontuacoes")
public class PontuacaoController {

    private final PontuacaoService pontuacaoService;

    public PontuacaoController(PontuacaoService pontuacaoService) {
        this.pontuacaoService = pontuacaoService;
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<CollectionModel<EntityModel<PontuacaoResponseDto>>> listarPontuacoesPorUsuario(@PathVariable Long usuarioId) {
        List<EntityModel<PontuacaoResponseDto>> pontuacoes = pontuacaoService.listarPontuacoesPorUsuario(usuarioId)
                .stream()
                .map(this::adicionarLinksPontuacao)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(pontuacoes,
                linkTo(methodOn(PontuacaoController.class).listarPontuacoesPorUsuario(usuarioId)).withSelfRel()));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<PontuacaoResponseDto>>> listarTodasPontuacoes() {
        List<EntityModel<PontuacaoResponseDto>> pontuacoes = pontuacaoService.listarTodasPontuacoes()
                .stream()
                .map(this::adicionarLinksPontuacao)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(pontuacoes,
                linkTo(methodOn(PontuacaoController.class).listarTodasPontuacoes()).withSelfRel()));
    }

    private EntityModel<PontuacaoResponseDto> adicionarLinksPontuacao(PontuacaoResponseDto pontuacaoDto) {
        return EntityModel.of(pontuacaoDto,
                linkTo(methodOn(PontuacaoController.class).listarTodasPontuacoes()).withRel("listar-todas-pontuacoes"));
    }
}
