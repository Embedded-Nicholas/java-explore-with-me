package ru.practicum.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import ru.practicum.StatsClient;

@Configuration
public class StatsClientConfig {

    @Bean
    public RestTemplate statsRestTemplate(@Value("${stat-server.url}") String baseUrl) {
        return new RestTemplateBuilder()
                .uriTemplateHandler(new DefaultUriBuilderFactory(baseUrl))
                .build();
    }

    @Bean
    public StatsClient statsClient(RestTemplate statsRestTemplate) {
        return new StatsClient(statsRestTemplate);
    }
}