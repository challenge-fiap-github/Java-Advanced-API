package com.odontovision.Java_API.controllers;

import com.odontovision.Java_API.entities.EnderecoClinica;
import com.odontovision.Java_API.services.EnderecoClinicaService;
import com.odontovision.Java_API.dtos.EnderecoClinicaDTO;
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
@RequestMapping("/enderecos-clinica")
public class EnderecoClinicaController {

    @Autowired
    private EnderecoClinicaService enderecoClinicaService;

    @PostMapping
    public ResponseEntity<EntityModel<EnderecoClinicaDTO>> cadastrarEnderecoClinica(@RequestBody EnderecoClinicaDTO dto) {
        EnderecoClinica enderecoClinica = enderecoClinicaService.salvarEnderecoClinica(dto);
        EnderecoClinicaDTO enderecoClinicaDTO = new EnderecoClinicaDTO(enderecoClinica);

        return ResponseEntity.ok(EntityModel.of(enderecoClinicaDTO,
                linkTo(methodOn(EnderecoClinicaController.class).buscarEnderecoClinicaPorId(enderecoClinica.getId())).withSelfRel(),
                linkTo(methodOn(EnderecoClinicaController.class).listarEnderecosClinica()).withRel("enderecos-clinica")));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<EnderecoClinicaDTO>> listarEnderecosClinica() {
        List<EnderecoClinica> enderecos = enderecoClinicaService.listarEnderecosClinica();
        List<EnderecoClinicaDTO> dtos = enderecos.stream()
                .map(EnderecoClinicaDTO::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(CollectionModel.of(dtos,
                linkTo(methodOn(EnderecoClinicaController.class).listarEnderecosClinica()).withSelfRel()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<EnderecoClinicaDTO>> buscarEnderecoClinicaPorId(@PathVariable Long id) {
        Optional<EnderecoClinica> enderecoClinica = enderecoClinicaService.buscarEnderecoClinicaPorId(id);

        return enderecoClinica.map(e -> ResponseEntity.ok(EntityModel.of(new EnderecoClinicaDTO(e),
                        linkTo(methodOn(EnderecoClinicaController.class).buscarEnderecoClinicaPorId(id)).withSelfRel(),
                        linkTo(methodOn(EnderecoClinicaController.class).listarEnderecosClinica()).withRel("enderecos-clinica"))))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEnderecoClinica(@PathVariable Long id) {
        enderecoClinicaService.excluirEnderecoClinica(id);
        return ResponseEntity.noContent().build();
    }
}
