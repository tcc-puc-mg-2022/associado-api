package br.com.pucminas.tcc.ms.associadoapi.web;

import br.com.pucminas.tcc.ms.associadoapi.model.SituacaoCarteirinhaEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@ApiModel(description = "Objeto resumo de cadastro de novo associado", value = "AssociadoResponse")
public class AssociadoResponse {

    @ApiModelProperty(value = "Código do Associado")
    @JsonProperty(index = 0)
    private Long codigo;

    @ApiModelProperty(value = "Plano do Associado")
    @JsonProperty(index = 1)
    private PlanoDTO plano;

    @ApiModelProperty(value = "Situação da carteirinha")
    @JsonProperty(index = 2)
    private SituacaoCarteirinhaEnum carteirinha;

}
