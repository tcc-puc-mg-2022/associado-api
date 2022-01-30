package br.com.pucminas.tcc.ms.associadoapi.web;

import br.com.pucminas.tcc.ms.associadoapi.model.CategoriaEnum;
import br.com.pucminas.tcc.ms.associadoapi.model.TipoAssociadoEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@ApiModel(description = "Objeto de cadastro de novo associado", value = "AssociadoRequest")
@NoArgsConstructor(access = AccessLevel.PACKAGE, force = true)
@AllArgsConstructor
public class AssociadoRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Size(min = 5, max = 40, message = "O nome deve ter entre {min} e {max} caracteres")
    @ApiModelProperty(required = true)
    @JsonProperty(index = 0)
    private String nome;

    @NotBlank(message = "O cpf é obrigatório")
    @CPF(message = "CPF inválido")
    @ApiModelProperty(required = true)
    @JsonProperty(index = 1)
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória")
    @ApiModelProperty(required = true)
    @JsonProperty(index = 2)
    private LocalDate dataNascimento;

    @NotNull(message = "ID do plano é obrigatório")
    @ApiModelProperty(value = "ID do plano escolhido",required = true)
    @JsonProperty(index = 3)
    private Long idPlano;

    @NotNull(message = "Tipo de Associado é obrigatório")
    @ApiModelProperty(required = true)
    @JsonProperty(index = 4)
    private TipoAssociadoEnum tipo;

    @NotNull(message = "Categoria do associado é obrigatória")
    @ApiModelProperty(required = true)
    @JsonProperty(index = 5)
    private CategoriaEnum categoria;
}
