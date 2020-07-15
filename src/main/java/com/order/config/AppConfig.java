package com.order.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.order.service.PersonService;
import com.order.service.PersonServiceImpl;
import com.order.util.RestUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestUtil restUtil(RestTemplate restTemplate) {
        return new RestUtil(restTemplate);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}
