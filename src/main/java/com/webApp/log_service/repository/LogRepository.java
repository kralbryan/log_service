package com.webApp.log_service.repository;

import com.webApp.log_service.model.LogEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

//CRUD (Create, Read, Update, Delete)
@Repository
public interface LogRepository extends JpaRepository<LogEntry, Long> {
    List<LogEntry> findByEventType(String eventType);
}
