package com.odontovision.Java_API.repositories;

import com.odontovision.Java_API.entities.ValidacaoChecklist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ValidacaoChecklistRepository extends JpaRepository<ValidacaoChecklist, Long> {
    List<ValidacaoChecklist> findByUsuarioId(Long usuarioId);
}