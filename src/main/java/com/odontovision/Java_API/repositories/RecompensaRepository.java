package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.Recompensa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecompensaRepository extends JpaRepository<Recompensa, Long> {
    List<Recompensa> findByPontosNecessariosLessThanEqual(Integer pontos);
}
