package br.com.pucminas.tcc.ms.associadoapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SituacaoCarteirinhaEnum {

    NAO_SOLICITADA(1),
    EM_PROCESSAMENTO(2),
    EMITIDA(3);

    final Integer situacao;
}
