package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.Procedimento;
import com.odontovision.Java_API.services.ProcedimentoService;
import com.odontovision.Java_API.dtos.ProcedimentoDTO;
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
@RequestMapping("/procedimentos")
public class ProcedimentoController {

    @Autowired
    private ProcedimentoService procedimentoService;

    @PostMapping
    public ResponseEntity<EntityModel<ProcedimentoDTO>> cadastrarProcedimento(@RequestBody ProcedimentoDTO dto) {
        Procedimento procedimento = procedimentoService.salvarProcedimento(dto);
        ProcedimentoDTO procedimentoDTO = new ProcedimentoDTO(procedimento);

        return ResponseEntity.ok(EntityModel.of(procedimentoDTO,
                linkTo(methodOn(ProcedimentoController.class).buscarProcedimentoPorId(procedimento.getId())).withSelfRel(),
                linkTo(methodOn(ProcedimentoController.class).listarProcedimentos()).withRel("procedimentos")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ProcedimentoDTO>> listarProcedimentos() {
        List<Procedimento> procedimentos = procedimentoService.listarProcedimentos();
        List<ProcedimentoDTO> dtos = procedimentos.stream()
                .map(ProcedimentoDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(ProcedimentoController.class).listarProcedimentos()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ProcedimentoDTO>> buscarProcedimentoPorId(@PathVariable Long id) {
        Optional<Procedimento> procedimento = procedimentoService.buscarProcedimentoPorId(id);

        return procedimento.map(p -> ResponseEntity.ok(EntityModel.of(new ProcedimentoDTO(p),
                        linkTo(methodOn(ProcedimentoController.class).buscarProcedimentoPorId(id)).withSelfRel(),
                        linkTo(methodOn(ProcedimentoController.class).listarProcedimentos()).withRel("procedimentos"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProcedimento(@PathVariable Long id) {
        procedimentoService.excluirProcedimento(id);
        return ResponseEntity.noContent().build();
    }
}