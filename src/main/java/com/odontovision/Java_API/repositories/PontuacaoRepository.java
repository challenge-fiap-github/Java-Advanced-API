package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.Pontuacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PontuacaoRepository extends JpaRepository<Pontuacao, Long> {
    List<Pontuacao> findByUsuarioId(Long usuarioId);
}
