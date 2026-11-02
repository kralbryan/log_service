//package com.webApp.log_service.service;
//
//import com.webApp.log_service.model.LogEntry;
//import com.webApp.log_service.repository.LogRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EventService {
//    private final LogRepository logRepository;
//    public EventService(LogRepository logRepository) {
//        this.logRepository = logRepository;
//    }
//    public List<LogEntry> getEvents(String logs) {
//        if ((logs == null) || logs.isEmpty()) {
//            return logRepository.findAll();
//        }
//        return logRepository.findByEventType(logs);
//    }
//}
