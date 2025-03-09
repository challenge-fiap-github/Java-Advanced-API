package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.Dentista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface DentistaRepository extends JpaRepository<Dentista, Long> {
    Optional<Dentista> findByCro(String cro);
    List<Dentista> findByEspecialidade(String especialidade);
}
