package com.webApp.log_service.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.webApp.log_service.service.LogService;

@Component
public class LogConsumer {

    private final LogService logService;


    public LogConsumer(LogService logService) {
        this.logService = logService;

    }

    @KafkaListener(topics = "logs", groupId = "central-logger")
    public void consume(String message) {
        System.out.println("Kafka'dan mesaj alındı: " + message);
        logService.saveLog(message);
    }
}


