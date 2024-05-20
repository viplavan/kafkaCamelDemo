package com.example.kafkaCamel.kafkaCamelDemo.routes.kafka;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.ERROR;

@Component
public class StockKafkaRouter extends RouteBuilder {

    final String KAFKA_ENDPOINT = "kafka:%s?brokers=localhost:29092";
    @Override
    public void configure() throws Exception {
        fromF(KAFKA_ENDPOINT, "stock-live")
                .log(ERROR, "[${header.kafka.OFFSET}] [${body}]");

    }
}
