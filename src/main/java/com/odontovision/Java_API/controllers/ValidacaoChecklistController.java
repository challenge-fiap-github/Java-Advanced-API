package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.ValidacaoChecklist;
import com.odontovision.Java_API.services.ValidacaoChecklistService;
import com.odontovision.Java_API.dtos.ValidacaoChecklistDTO;
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
@RequestMapping("/validacoes-checklist")
public class ValidacaoChecklistController {

    @Autowired
    private ValidacaoChecklistService validacaoChecklistService;

    @PostMapping
    public ResponseEntity<EntityModel<ValidacaoChecklistDTO>> registrarValidacaoChecklist(@RequestBody ValidacaoChecklistDTO dto) {
        ValidacaoChecklist validacaoChecklist = validacaoChecklistService.salvarValidacaoChecklist(dto);
        ValidacaoChecklistDTO validacaoChecklistDTO = new ValidacaoChecklistDTO(validacaoChecklist);

        return ResponseEntity.ok(EntityModel.of(validacaoChecklistDTO,
                linkTo(methodOn(ValidacaoChecklistController.class)
                        .buscarValidacaoChecklist(validacaoChecklist.getId()))
                        .withSelfRel(),
                linkTo(methodOn(ValidacaoChecklistController.class).listarValidacoesChecklist()).withRel("validacoes-checklist")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ValidacaoChecklistDTO>> listarValidacoesChecklist() {
        List<ValidacaoChecklist> validacoes = validacaoChecklistService.listarValidacoesChecklist();
        List<ValidacaoChecklistDTO> dtos = validacoes.stream()
                .map(ValidacaoChecklistDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(ValidacaoChecklistController.class).listarValidacoesChecklist()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ValidacaoChecklistDTO>> buscarValidacaoChecklist(@PathVariable Long id) {
        Optional<ValidacaoChecklist> validacaoChecklist = validacaoChecklistService.buscarValidacaoChecklist(id);

        return validacaoChecklist.map(vc -> ResponseEntity.ok(EntityModel.of(new ValidacaoChecklistDTO(vc),
                        linkTo(methodOn(ValidacaoChecklistController.class)
                                .buscarValidacaoChecklist(id)).withSelfRel(),
                        linkTo(methodOn(ValidacaoChecklistController.class).listarValidacoesChecklist()).withRel("validacoes-checklist"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirValidacaoChecklist(@PathVariable Long id) {
        validacaoChecklistService.excluirValidacaoChecklist(id);
        return ResponseEntity.noContent().build();
    }
}