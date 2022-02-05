/*
 * Copyright (c) 2022, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.associadoapi.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.*;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration {

    private static final List<Response> DEFAULT_ERRORS = List.of(
            new ResponseBuilder().code("401").description("Não Autorizado").build(),
            new ResponseBuilder().code("403").description("Você não tem permissão para realizar essa operação").build(),
            new ResponseBuilder().code("404").description("Recurso não encontrado").build(),
            new ResponseBuilder().code("500").description("Erro no processamento da requisição").build()
    );

    private static final List<Response> POST_DEFAULT_ERRORS = DEFAULT_ERRORS.stream()
            .filter(r -> !"404".equalsIgnoreCase(r.getCode())).collect(Collectors.toList());

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .globalRequestParameters(List.of(new RequestParameterBuilder()
                        .name("Authorization")
                        .description("Bearer token")
                        .required(false)
                        .in(ParameterType.HEADER)
                        .build()))
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(Predicate.not(PathSelectors.regex("/error.*")))
                .paths(Predicate.not(PathSelectors.regex("/actuator.*")))
                .build()
                .enable(true)
                .useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET, DEFAULT_ERRORS)
                .globalResponses(HttpMethod.POST, POST_DEFAULT_ERRORS)
                .globalResponses(HttpMethod.PUT, DEFAULT_ERRORS)
                .globalResponses(HttpMethod.DELETE, DEFAULT_ERRORS)
                .apiInfo(new ApiInfoBuilder()
                        .title("API de Associados")
                        .description("Essa API tem como finalidade a gestão de dados de associados")
                        .contact(new Contact("BOA SAUDE", "https://www.boasaude.com.br/", "codti@boasaude" +
                                ".com.br"))
                        .version("1.0.0")
                        .build());
    }
}
