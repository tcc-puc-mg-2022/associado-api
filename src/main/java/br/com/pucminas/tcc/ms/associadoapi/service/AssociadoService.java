package br.com.pucminas.tcc.ms.associadoapi.service;

import br.com.pucminas.tcc.ms.associadoapi.exception.BusinessException;
import br.com.pucminas.tcc.ms.associadoapi.model.Associado;
import br.com.pucminas.tcc.ms.associadoapi.repository.AssociadoRepository;
import br.com.pucminas.tcc.ms.associadoapi.repository.PlanoRepository;
import br.com.pucminas.tcc.ms.associadoapi.utils.AssertUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssociadoService {

    @NonNull
    private AssociadoRepository repository;

    @NonNull
    private PlanoRepository planoRepository;

    @Transactional
    public Associado cadastrar(Associado associado) {
        associado.setId(null);
        AssertUtils.assertFalse(repository.existsByCpf(associado.getPessoaFisica().getCpf()),
                "Associado já cadastrado");

        final var plano = planoRepository.findById(associado.getPlano().getId())
                .orElseThrow(() -> new BusinessException("Plano não encontrado"));

        associado.setPlano(plano);

        return repository.save(associado);
    }

}
