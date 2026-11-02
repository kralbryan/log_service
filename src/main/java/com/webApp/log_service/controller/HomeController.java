package com.webApp.log_service.controller;

import com.webApp.log_service.model.LogEntry;
import com.webApp.log_service.repository.LogRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final LogRepository logRepository;

    public HomeController(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @GetMapping("/home")
    public String home(
            @RequestParam(required = false) String filter,
            Model model) {

        List<LogEntry> logs;
        if (filter == null || filter.isEmpty()) {
            logs = logRepository.findAll();
        } else {
            logs = logRepository.findByEventType(filter);
        }

        model.addAttribute("logs", logs);
        model.addAttribute("selectedFilter", filter);

        return "home";
    }
}
