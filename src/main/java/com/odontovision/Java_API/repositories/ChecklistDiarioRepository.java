package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.ChecklistDiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChecklistDiarioRepository extends JpaRepository<ChecklistDiario, Long> {
    List<ChecklistDiario> findByUsuarioId(Long usuarioId);
}