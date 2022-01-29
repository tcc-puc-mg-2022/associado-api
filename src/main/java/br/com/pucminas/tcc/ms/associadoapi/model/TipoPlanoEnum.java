package br.com.pucminas.tcc.ms.associadoapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoPlanoEnum {

    MEDICO(1),
    MEDICO_ODONTOLOGICO(2);

    final Integer tipo;
}
