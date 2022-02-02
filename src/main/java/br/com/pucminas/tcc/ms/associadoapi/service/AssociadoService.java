package br.com.pucminas.tcc.ms.associadoapi.service;

import br.com.pucminas.tcc.ms.associadoapi.rabbitmq.configuration.QueueConfig;
import br.com.pucminas.tcc.ms.associadoapi.exception.BusinessException;
import br.com.pucminas.tcc.ms.associadoapi.model.Associado;
import br.com.pucminas.tcc.ms.associadoapi.model.SituacaoCarteirinhaEnum;
import br.com.pucminas.tcc.ms.associadoapi.repository.AssociadoRepository;
import br.com.pucminas.tcc.ms.associadoapi.repository.PlanoRepository;
import br.com.pucminas.tcc.ms.associadoapi.utils.AssertUtils;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AssociadoService {

    @NonNull
    private AssociadoRepository repository;

    @NonNull
    private PlanoRepository planoRepository;

    @NonNull
    private QueueConfig queueConfig;

    private static final String NM_CART_QUEUE_IN = "associado.cart.in";

    @Transactional
    public Associado cadastrar(Associado associado) {
        associado.setId(null);
        AssertUtils.assertFalse(repository.existsByCpf(associado.getPessoaFisica().getCpf()),
                "Associado já cadastrado");
        associado.setPlano(planoRepository.findById(associado.getPlano().getId())
                .orElseThrow(() -> new BusinessException("Plano não encontrado")));
        associado.setValor(BigDecimal.valueOf(250.50)); // Valor mockado. Deve vir do legado
        associado.setSitCarteirinha(SituacaoCarteirinhaEnum.NAO_SOLICITADA);
        return repository.save(associado);
    }

    @Transactional
    public void solicitarCarteirinha(Associado associado) {
        try {
            final var connection = this.queueConfig.getConnection();
            try (var channel = connection.createChannel()) {
                final var message = "creation_request_id_" + associado.getId().toString();
                channel.basicPublish("", NM_CART_QUEUE_IN, null, message.getBytes(StandardCharsets.UTF_8));
            }
            connection.close();
            associado.setSitCarteirinha(SituacaoCarteirinhaEnum.EM_PROCESSAMENTO);
            this.repository.save(associado);
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Transactional
    public void finalizarEmissaoCarteirinha(Long idAssociado) {
        final var associado = this.repository.findById(idAssociado)
                .orElseThrow(() -> new BusinessException("Associado não encontrado"));
        associado.setSitCarteirinha(SituacaoCarteirinhaEnum.EMITIDA);
        this.repository.save(associado);
        log.info("Carteirinha emitida!");
    }

    public Optional<Associado> buscarPorId(Long idAssociado) {
        return repository.findById(idAssociado);
    }

}
