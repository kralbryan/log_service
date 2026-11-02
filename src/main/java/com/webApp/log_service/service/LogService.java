package com.webApp.log_service.service;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webApp.log_service.model.LogEntry;
import com.webApp.log_service.repository.LogRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class LogService {

    private final LogRepository logRepository;
    private final ObjectMapper objectMapper;

    public LogService(LogRepository logRepository, ObjectMapper objectMapper) {
        this.logRepository = logRepository;
        this.objectMapper = objectMapper;
    }

    public void saveLog(String message) {
        try {
            JsonNode json = objectMapper.readTree(message);
            LogEntry logEntry = LogEntry.builder()
                    .eventType(json.get("event").asText())
                    .message(json.has("username") ? json.get("username").asText() : null)
                    .reason(json.has("reason") ? json.get("reason").asText() : null)
                    .whichProducer(json.has("producer") ? json.get("producer").asText() : null)
                    .timestamp(LocalDateTime.now())
                    .build();
            logRepository.save(logEntry);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
