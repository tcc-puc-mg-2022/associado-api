package br.com.pucminas.tcc.ms.associadoapi.rabbitmq.configuration;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@Configuration
public class QueueConfig {

    @Value("${spring.rabbitmq.host}")
    private String rabbitmqHost;

    @Value("${spring.rabbitmq.username}")
    private String rabbitmqUser;

    @Value("${spring.rabbitmq.password}")
    private String rabbitmqPassword;

    public Connection getConnection() throws IOException, TimeoutException {
        final var factory = new ConnectionFactory();
        factory.setHost(rabbitmqHost);
        factory.setUsername(rabbitmqUser);
        factory.setPassword(rabbitmqPassword);

        return factory.newConnection();
    }

}
