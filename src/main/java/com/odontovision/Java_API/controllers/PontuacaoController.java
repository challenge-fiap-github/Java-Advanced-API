package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Pontuacao;
import com.odontovision.Java_API.services.PontuacaoService;
import com.odontovision.Java_API.dtos.PontuacaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/pontuacoes")
public class PontuacaoController {

    @Autowired
    private PontuacaoService pontuacaoService;

    @PostMapping
    public ResponseEntity<EntityModel<PontuacaoDTO>> registrarPontuacao(@RequestBody PontuacaoDTO dto) {
        Pontuacao pontuacao = pontuacaoService.registrarPontuacao(dto);
        PontuacaoDTO pontuacaoDTO = new PontuacaoDTO(pontuacao);

        return ResponseEntity.ok(EntityModel.of(pontuacaoDTO,
                linkTo(methodOn(PontuacaoController.class).buscarPontuacaoPorId(pontuacao.getId())).withSelfRel(),
                linkTo(methodOn(PontuacaoController.class).listarPontuacoes()).withRel("pontuacoes")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<PontuacaoDTO>> listarPontuacoes() {
        List<Pontuacao> pontuacoes = pontuacaoService.listarPontuacoes();
        List<PontuacaoDTO> dtos = pontuacoes.stream()
                .map(PontuacaoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(PontuacaoController.class).listarPontuacoes()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PontuacaoDTO>> buscarPontuacaoPorId(@PathVariable Long id) {
        Optional<Pontuacao> pontuacao = pontuacaoService.buscarPontuacaoPorId(id);

        return pontuacao.map(p -> ResponseEntity.ok(EntityModel.of(new PontuacaoDTO(p),
                        linkTo(methodOn(PontuacaoController.class).buscarPontuacaoPorId(id)).withSelfRel(),
                        linkTo(methodOn(PontuacaoController.class).listarPontuacoes()).withRel("pontuacoes"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPontuacao(@PathVariable Long id) {
        pontuacaoService.excluirPontuacao(id);
        return ResponseEntity.noContent().build();
    }
}