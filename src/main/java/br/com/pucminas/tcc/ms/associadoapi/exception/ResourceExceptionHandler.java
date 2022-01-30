/*
 * Copyright (c) 2020, FHE Poupex and/or its affiliates. All rights reserved.
 * FHE POUPEX PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package br.com.pucminas.tcc.ms.associadoapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
@Slf4j
public class ResourceExceptionHandler {

    private static final String MSG_ERROR_BASE = "Erro ao excutar operação";

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Object> handleValidationExceptions(ResponseStatusException ex) {
        return new ResponseEntity<>(new ApiErrors(ex), ex.getStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(MethodArgumentNotValidException ex) {
        return new ApiErrors(ex.getBindingResult());
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(BindException ex) {
        return new ApiErrors(ex.getBindingResult());
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(BusinessException ex) {
        return new ApiErrors(ex);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(Exception ex) {
        log.error(MSG_ERROR_BASE.concat(StringUtils.defaultString(ex.getMessage())), ex);
        return new ApiErrors(MSG_ERROR_BASE);
    }
}
