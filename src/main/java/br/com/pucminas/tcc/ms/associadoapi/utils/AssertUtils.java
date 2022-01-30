package br.com.pucminas.tcc.ms.associadoapi.utils;

import br.com.pucminas.tcc.ms.associadoapi.exception.BusinessException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AssertUtils {

    public void assertTrue(boolean expression, String message) {
        if (!expression)
            throw new BusinessException(message);
    }

    public void assertFalse(boolean expression, String message) {
        if (expression)
            throw new BusinessException(message);
    }
}
