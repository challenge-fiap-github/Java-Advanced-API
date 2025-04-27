package com.odontovision.Java_API.repository;

import com.odontovision.Java_API.entity.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {
    List<Pontuacao> findByUsuarioId(Long usuarioId);
}
