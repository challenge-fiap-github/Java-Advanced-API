package com.odontovision.Java_API.service;

import com.odontovision.Java_API.entity.Auditoria;
import java.util.List;
import java.util.Optional;

public interface AuditoriaService {
    List<Auditoria> listarTodas();
    Optional<Auditoria> buscarPorId(Long id);
    Auditoria criar(Auditoria auditoria);
}