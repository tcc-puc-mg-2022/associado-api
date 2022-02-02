package br.com.pucminas.tcc.ms.associadoapi.rabbitmq.consumer;

import br.com.pucminas.tcc.ms.associadoapi.service.AssociadoService;
import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CarteirinhaConsumer {

    @NonNull
    private AssociadoService service;

    @RabbitListener(queues = "associado.cart.out")
    public void receiveMessage(String message) {
        final var id = message.split("_id_")[1];
        if (Objects.nonNull(id)) {
            this.service.finalizarEmissaoCarteirinha(Long.parseLong(id));
        }
    }
}
