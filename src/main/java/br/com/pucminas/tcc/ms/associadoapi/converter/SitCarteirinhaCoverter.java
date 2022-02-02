package br.com.pucminas.tcc.ms.associadoapi.converter;

import br.com.pucminas.tcc.ms.associadoapi.model.CategoriaEnum;
import br.com.pucminas.tcc.ms.associadoapi.model.SituacaoCarteirinhaEnum;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SitCarteirinhaCoverter implements AttributeConverter<SituacaoCarteirinhaEnum, Integer> {

    @Override
    public Integer convertToDatabaseColumn(SituacaoCarteirinhaEnum situacao) {
        return Objects.nonNull(situacao) ? situacao.getSituacao() : null;
    }

    @Override
    public SituacaoCarteirinhaEnum convertToEntityAttribute(Integer codigo) {
        return Stream.of(SituacaoCarteirinhaEnum.values())
                .filter(situacao -> situacao.getSituacao().equals(codigo))
                .findFirst().orElseThrow();
    }
}
