package br.com.pucminas.tcc.ms.associadoapi.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CategoriaEnum {

    ATIVO(1),
    SUSPENSO(2),
    INATIVO(3);

    final Integer categoria;
}
