package com.odontovision.Java_API.exception;

/**
 * Lançada quando não se encontra o vínculo Consulta–Procedimento.
 */
public class ConsultaProcedimentoNotFoundException extends ResourceNotFoundException {
    public ConsultaProcedimentoNotFoundException(Long consultaId, Long procedimentoId) {
        super(String.format(
                "ConsultaProcedimento não encontrado [consultaId=%d, procedimentoId=%d]",
                consultaId, procedimentoId
        ));
    }
}