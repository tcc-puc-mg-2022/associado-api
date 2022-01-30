package br.com.pucminas.tcc.ms.associadoapi.converter;

import br.com.pucminas.tcc.ms.associadoapi.model.CategoriaEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class CategoriaCoverter implements AttributeConverter<CategoriaEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(CategoriaEnum categoria) {
        return Objects.nonNull(categoria) ? categoria.getCategoria() : null;
    }

    @Override
    public CategoriaEnum convertToEntityAttribute(Integer codigo) {
        return Stream.of(CategoriaEnum.values())
                .filter(categoria -> categoria.getCategoria().equals(codigo))
                .findFirst().orElseThrow();
    }
}
