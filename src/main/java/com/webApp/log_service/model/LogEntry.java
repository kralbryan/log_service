package com.webApp.log_service.model;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity //Sınıf bir JPA varlığı ve db'de bir tabloyla eşleşir
@Table(name = "logs") //bu anotasyon kullanılmasa otomatik olarak sınıf adı kullanılırdı(LogEntry table)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Builder design pattern (nesneler güvenilir ve okunaklı oluşturulur)
public class LogEntry {

    @Id //Bu alan primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key değeri otomatik artacak (id)
    private Long id;

    private String eventType;

    private String reason;

    @Column(columnDefinition = "TEXT") // mesaj alanı db'de text
    private String message;//username

    private LocalDateTime timestamp; // log kaydı ne zaman oluşturulacak

    private String whichProducer;
}
//buraya belki event type ekler ve onu tutarız databasede