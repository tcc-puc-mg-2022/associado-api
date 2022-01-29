package br.com.pucminas.tcc.ms.associadoapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoAssociadoEnum {

    INDIVIDUAL(1),
    EMPRESARIAL(2);

    final Integer tipo;
}
