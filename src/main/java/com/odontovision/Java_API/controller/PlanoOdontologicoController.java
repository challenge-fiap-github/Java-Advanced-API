package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.PlanoOdontologicoRequestDto;
import com.odontovision.Java_API.dto.PlanoOdontologicoResponseDto;
import com.odontovision.Java_API.service.PlanoOdontologicoService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/planos")
public class PlanoOdontologicoController {

    private final PlanoOdontologicoService planoService;

    public PlanoOdontologicoController(PlanoOdontologicoService planoService) {
        this.planoService = planoService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<PlanoOdontologicoResponseDto>> criarPlano(@RequestBody @Valid PlanoOdontologicoRequestDto planoRequestDto) {
        PlanoOdontologicoResponseDto novoPlano = planoService.criarPlano(planoRequestDto);
        return ResponseEntity.ok(adicionarLinksPlano(novoPlano));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<PlanoOdontologicoResponseDto>> atualizarPlano(@PathVariable Long id, @RequestBody @Valid PlanoOdontologicoRequestDto planoRequestDto) {
        PlanoOdontologicoResponseDto atualizado = planoService.atualizarPlano(id, planoRequestDto);
        return ResponseEntity.ok(adicionarLinksPlano(atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPlano(@PathVariable Long id) {
        planoService.deletarPlano(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PlanoOdontologicoResponseDto>> buscarPlanoPorId(@PathVariable Long id) {
        PlanoOdontologicoResponseDto plano = planoService.buscarPorId(id);
        return ResponseEntity.ok(adicionarLinksPlano(plano));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<PlanoOdontologicoResponseDto>>> listarTodosPlanos() {
        List<EntityModel<PlanoOdontologicoResponseDto>> planos = planoService.listarTodos()
                .stream()
                .map(this::adicionarLinksPlano)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(planos,
                linkTo(methodOn(PlanoOdontologicoController.class).listarTodosPlanos()).withSelfRel()));
    }

    private EntityModel<PlanoOdontologicoResponseDto> adicionarLinksPlano(PlanoOdontologicoResponseDto planoDto) {
        return EntityModel.of(planoDto,
                linkTo(methodOn(PlanoOdontologicoController.class).buscarPlanoPorId(planoDto.id())).withSelfRel(),
                linkTo(methodOn(PlanoOdontologicoController.class).listarTodosPlanos()).withRel("listar-todos-planos"));
    }
}
