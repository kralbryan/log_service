package com.webApp.log_service.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {
    // Eğer özel bir datasource ayarı yapmayacaksan boş kalabilir.
    //Auto configuration kullanır .
    //application.yml içindeki db ayarlarını oto algılar ve kendisi benim için DataSource bean oluşturur.
}