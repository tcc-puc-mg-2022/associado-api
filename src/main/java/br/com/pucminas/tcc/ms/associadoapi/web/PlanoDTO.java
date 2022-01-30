package br.com.pucminas.tcc.ms.associadoapi.web;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@ApiModel(description = "Objeto de dados de plano", value = "PlanoDTO")
@NoArgsConstructor(access = AccessLevel.PACKAGE, force = true)
@AllArgsConstructor
public class PlanoDTO {

    @ApiModelProperty(value = "Código do plano")
    @JsonProperty(index = 0)
    private Long codigo;

    @ApiModelProperty(value = "Nome do plano")
    @JsonProperty(index = 1)
    private String nome;

    @ApiModelProperty(value = "Valor do plano")
    @JsonProperty(index = 2)
    private BigDecimal valor;
}
