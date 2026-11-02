package com.webApp.log_service.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka //kafka dinleyici özelliklerini aktifleştirir
@Configuration //bu sınıfın bir yapılandırma sınfı olduğunu belirtir(Uygulama bağlamında yönetilen
// Bean ler olarak düşünülebilir)
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, String> consumerFactory() { //consumer factory üretir,
        // uygulama kafka brokere nasıl bağlanacak onu belirler
        Map<String, Object> configPropsMap = new HashMap<>();
        configPropsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092"); // Kafka broker adresi
        configPropsMap.put(ConsumerConfig.GROUP_ID_CONFIG, "central-logger"); // Consumer group
        configPropsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);//Kafka'dan gelen mesajların key.value
        configPropsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);//değerleri nasıl okunacak o belirlenir


        return new DefaultKafkaConsumerFactory<>(configPropsMap);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}