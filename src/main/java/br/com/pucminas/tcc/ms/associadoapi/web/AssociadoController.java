package br.com.pucminas.tcc.ms.associadoapi.web;

import br.com.pucminas.tcc.ms.associadoapi.model.Associado;
import br.com.pucminas.tcc.ms.associadoapi.model.PessoaFisica;
import br.com.pucminas.tcc.ms.associadoapi.model.Plano;
import br.com.pucminas.tcc.ms.associadoapi.service.AssociadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Api(tags = "Associados", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("v1/associados")
public class AssociadoController {

    @NonNull
    AssociadoService service;

    @ApiOperation(value = "Salvar um novo associado", response = AssociadoResponse.class)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AssociadoResponse salvar(@RequestBody AssociadoRequest request) {
        return this.entityToResponse(service.cadastrar(this.requestToEntity(request)));
    }

    private Associado requestToEntity(AssociadoRequest request) {
        return Associado.builder()
                .pessoaFisica(PessoaFisica.builder()
                        .cpf(request.getCpf())
                        .nome(request.getNome())
                        .dataNascimento(request.getDataNascimento())
                        .build())
                .plano(Plano.builder()
                        .id(request.getIdPlano())
                        .build())
                .tipo(request.getTipo())
                .categoria(request.getCategoria())
                .build();
    }

    private AssociadoResponse entityToResponse(Associado associado) {
        return AssociadoResponse.builder()
                .codigo(associado.getId())
                .plano(PlanoDTO.builder()
                        .codigo(associado.getPlano().getId())
                        .nome(associado.getPlano().getNome())
                        .valor(associado.getValor())
                        .build())
                .build();
    }

}
