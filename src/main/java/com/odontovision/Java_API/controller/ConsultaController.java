package com.odontovision.Java_API.controller;

import com.odontovision.Java_API.dto.ConsultaRequestDto;
import com.odontovision.Java_API.dto.ConsultaResponseDto;
import com.odontovision.Java_API.service.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping
    public ResponseEntity<EntityModel<ConsultaResponseDto>> criarConsulta(@RequestBody @Valid ConsultaRequestDto consultaRequestDto) {
        ConsultaResponseDto novaConsulta = consultaService.criarConsulta(consultaRequestDto);
        return ResponseEntity.ok(adicionarLinksConsulta(novaConsulta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<ConsultaResponseDto>> atualizarConsulta(@PathVariable Long id, @RequestBody @Valid ConsultaRequestDto consultaRequestDto) {
        ConsultaResponseDto atualizada = consultaService.atualizarConsulta(id, consultaRequestDto);
        return ResponseEntity.ok(adicionarLinksConsulta(atualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<ConsultaResponseDto>> buscarConsultaPorId(@PathVariable Long id) {
        ConsultaResponseDto consulta = consultaService.buscarPorId(id);
        return ResponseEntity.ok(adicionarLinksConsulta(consulta));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<ConsultaResponseDto>>> listarTodasConsultas() {
        List<EntityModel<ConsultaResponseDto>> consultas = consultaService.listarTodas()
                .stream()
                .map(this::adicionarLinksConsulta)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(consultas,
                linkTo(methodOn(ConsultaController.class).listarTodasConsultas()).withSelfRel()));
    }

    private EntityModel<ConsultaResponseDto> adicionarLinksConsulta(ConsultaResponseDto consultaDto) {
        return EntityModel.of(consultaDto,
                linkTo(methodOn(ConsultaController.class).buscarConsultaPorId(consultaDto.id())).withSelfRel(),
                linkTo(methodOn(ConsultaController.class).listarTodasConsultas()).withRel("listar-todas-consultas"));
    }
}
