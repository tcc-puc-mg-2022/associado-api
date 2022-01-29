package br.com.pucminas.tcc.ms.associadoapi.web;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(tags = "Associados", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("v1/associados")
public class AssociadoController {

    @ApiOperation(value = "Serviço de testes", response = String.class)
    @GetMapping
    public String testeGet() {
        return "Passou no primeiro teste";
    }

}
