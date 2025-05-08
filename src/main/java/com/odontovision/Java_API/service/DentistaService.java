package com.odontovision.Java_API.service;

import com.odontovision.Java_API.entity.Dentista;

import java.util.List;
import java.util.Optional;

public interface DentistaService {
    List<Dentista> listarTodos();
    Optional<Dentista> buscarPorId(Long id);
    Dentista criar(Dentista d);
    Dentista atualizar(Long id, Dentista d);
    void excluir(Long id);
}