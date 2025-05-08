package com.odontovision.Java_API.exception;

/**
 * Lançada quando não se encontra o vínculo Plano–Procedimento.
 */
public class PlanoProcedimentoNotFoundException extends ResourceNotFoundException {
    public PlanoProcedimentoNotFoundException(Long planoId, Long procedimentoId) {
        super(String.format(
                "Plano–Procedimento não encontrado (planoId=%d, procedimentoId=%d)",
                planoId, procedimentoId
        ));
    }
}