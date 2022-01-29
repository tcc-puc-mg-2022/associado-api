package br.com.pucminas.tcc.ms.associadoapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Entity
//@Table(name = "associado", schema = "associado")
public class Associado {

    //@Id
    private Long id;

}
