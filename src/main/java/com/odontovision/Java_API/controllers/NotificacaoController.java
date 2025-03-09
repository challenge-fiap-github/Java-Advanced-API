package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Notificacao;
import com.odontovision.Java_API.services.NotificacaoService;
import com.odontovision.Java_API.dtos.NotificacaoDTO;
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
@RequestMapping("/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    public ResponseEntity<EntityModel<NotificacaoDTO>> cadastrarNotificacao(@RequestBody NotificacaoDTO dto) {
        Notificacao notificacao = notificacaoService.salvarNotificacao(dto);
        NotificacaoDTO notificacaoDTO = new NotificacaoDTO(notificacao);

        return ResponseEntity.ok(EntityModel.of(notificacaoDTO,
                linkTo(methodOn(NotificacaoController.class).buscarNotificacaoPorId(notificacao.getId())).withSelfRel(),
                linkTo(methodOn(NotificacaoController.class).listarNotificacoes()).withRel("notificacoes")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<NotificacaoDTO>> listarNotificacoes() {
        List<Notificacao> notificacoes = notificacaoService.listarNotificacoes();
        List<NotificacaoDTO> dtos = notificacoes.stream()
                .map(NotificacaoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(NotificacaoController.class).listarNotificacoes()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<NotificacaoDTO>> buscarNotificacaoPorId(@PathVariable Long id) {
        Optional<Notificacao> notificacao = notificacaoService.buscarNotificacaoPorId(id);

        return notificacao.map(n -> ResponseEntity.ok(EntityModel.of(new NotificacaoDTO(n),
                        linkTo(methodOn(NotificacaoController.class).buscarNotificacaoPorId(id)).withSelfRel(),
                        linkTo(methodOn(NotificacaoController.class).listarNotificacoes()).withRel("notificacoes"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirNotificacao(@PathVariable Long id) {
        notificacaoService.excluirNotificacao(id);
        return ResponseEntity.noContent().build();
    }
}
